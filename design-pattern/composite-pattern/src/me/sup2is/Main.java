package me.sup2is;

public class Main {

    public static void main(String[] args) {

        Folder folder1 = new Folder("최상위 폴더");
        File myFile1 = new File("myFile1");
        File myFile2 = new File("myFile2");
        folder1.addFile(myFile1);
        folder1.addFile(myFile2);

        Folder folder2 = new Folder( "1depth");
        File myFile3 = new File("myFile3");
        File myFile4 = new File("myFile4");
        folder2.addFile(myFile3);
        folder2.addFile(myFile4);

        Folder folder3 = new Folder("2depth");
        File myFile5 = new File("myFile5");
        File myFile6 = new File("myFile6");
        folder3.addFile(myFile5);
        folder3.addFile(myFile6);

        Folder folder4 = new Folder("3depth");
        File myFile7 = new File("myFile7");
        File myFile8 = new File("myFile8");
        folder4.addFile(myFile7);
        folder4.addFile(myFile8);

        folder1.addFile(folder2);
        folder2.addFile(folder3);
        folder3.addFile(folder4);

        folder1.print();
        System.out.println("====================");
        folder2.print();
        System.out.println("====================");
        folder3.print();
        System.out.println("====================");

    }
}
