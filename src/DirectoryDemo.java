import java.io.File;
import java.util.ArrayList;

public class DirectoryDemo {

    public String getExtension(String path){
        System.out.println(path);
        return path.substring(path.lastIndexOf("."));
    }

    public  String getFileName(String path){
        return path.substring(0,path.lastIndexOf("."));
    }

    public String procssMINEType(String ext){
        switch (ext){
            case ".txt" : return "text/plain" ;
            case  ".jpeg" : return "image/jpeg";
            case ".jpg": return "image/jpg";
            case ".pdf": return "application/pdf";
            case ".gif": return "image/gif";
            case ".docx": return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }
        return null;
    }

    /*public String showErrorScreen(){

    }*/



    public String processPath(String path){
        String name = null;
        System.out.println("PRCOESS PATH IS CALLED WITH: "+path);

            String[]separatedValues = path.split(" ");
            String pathFromURL = separatedValues[1];
            System.out.println("The path from URL is : " + pathFromURL);

            name = pathFromURL.substring(1);
            System.out.println(name);

        return name;
    }

    public boolean isDirectory(String path){
        File f = new File(path);
        if(f.isDirectory()) return true;
        return false;
    }



    public boolean doesExist(String path){
        File f = new File(path);
        return f.exists();
    }

    public String processHtml(ArrayList<String>links ){
        String htmlFile = "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "\t</head>\n" +
                "\t<body>\n" ;

        for (String fileLinks:
             links) {
            htmlFile = htmlFile + "\t\t"+fileLinks+"\n";
        }

        htmlFile += "\t</body>\n" +
                "</html>";

        return htmlFile;
    }

    public ArrayList<String> ShowDirectory(String pathName){
        //System.out.println("The path name is: "+pathName);
       ArrayList <String> generatedlinks = new ArrayList<>();

        String dirname = pathName;
        File f1 = new File(dirname);

        if (f1.isDirectory()) {
            String s[] = f1.list();
            //generating html links
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    //System.out.println("Inserting this to the list: "+pathName+"/"+s[i]);
                    generatedlinks.add("<p><b><a href=\""+"/"+f1.getPath()+"/"+s[i]+"\">"+s[i]+"</a></b></p>");
                    //System.out.println(s[i] + " is a directory");

                } else {

                    //System.out.println("The file name is: "+f.getName());
                    //System.out.println("Pathname in file: "+pathName);
                    generatedlinks.add("<p><a href=\""+"/"+f1.getPath()+"/"+s[i]+"\">"+s[i]+"</a></p>");
                    //System.out.println(s[i] + " is a file");
                }
            }


        } else {
            //System.out.println(dirname + " is not a directory");
        }


        return generatedlinks;
    }




    public static void main(String args[]) {
    /*String dirname = "root";
    File f1 = new File(dirname);

    if (f1.isDirectory()) {
        System.out.println("Directory of " + dirname);
        String s[] = f1.list();

        for (int i = 0; i < s.length; i++) {
            File f = new File(dirname + "/" + s[i]);
            if (f.isDirectory()) {
                System.out.println(s[i] + " is a directory");
            } else {
                System.out.println(s[i] + " is a file");
            }
        }
    } else {
        System.out.println(dirname + " is not a directory");
    }*/

    DirectoryDemo d = new DirectoryDemo();
    ArrayList<String>lists  = d.ShowDirectory("root\\dir1");
        for (String l:
             lists) {
            System.out.println(l);
        }
        //System.out.println(d.processPath("E:\\ACADEMICS\\3-2\\16-batch\\NW LAB\\OFFLINE 1\\Offline 1\\root"));
        System.out.println(d.processHtml(lists));

        //System.out.println(d.processPath("GET /E:/ACADEMICS/3-2/16-batch/NW%20LAB/OFFLINE%201/Offline%201/root HTTP/1.1"));


}
}
