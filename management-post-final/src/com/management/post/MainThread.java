package com.management.post;

public class MainThread {
    //Thực hiện
    public static void main(String[] args) {
        boolean condition = true;
        while (condition) {
            switch (menu()) {
                case 1:
                    morePosts();
                    break;
                case 2:
                    showListOfPosts(listPost);
                    break;
                case 3:
                    condition = exitTheProgram();
                    break;
                default:
                    reEnterRequired();
                    break;
            }
        }
    }

    //Khai báo biến chung.
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static java.util.ArrayList<InformationPosts> listPost = new java.util.ArrayList();

    //Khai báo function
    private static int menu() {
        System.out.println("\n\n" +
                "WELCOME TO POSTS MANAGEMENT PROGRAM !!!\n");
        System.out.println(String.format("//////////////////////////////////////////////////////"));
        System.out.println(String.format("//                                                  //"));
        System.out.println(String.format("//    1. MORE POST.                                 //"));
        System.out.println(String.format("//    2. SHOW LIST OF POSTS.                        //"));
        System.out.println(String.format("//    3. THE END.                                   //"));
        System.out.println(String.format("//                                                  //"));
        System.out.println(String.format("//////////////////////////////////////////////////////"));
        System.out.print(String.format("Choose: "));
        int choose = scanner.nextInt();
        scanner.nextLine();
        return choose;
    }

    private static java.util.ArrayList<InformationPosts> morePosts() {
        String choose;
        int i = 1;
        do {
            InformationPosts post = new InformationPosts();
            System.out.println(String.format("\nmore posts %s:", i));
            System.out.print("Enter code posts: ");
            post.setCode(scanner.nextLine());
            System.out.print("Enter the posts title: ");
            post.setTitle(scanner.nextLine());
            System.out.print("Enter a description of the posts: ");
            post.setDescription(scanner.nextLine());
            System.out.print("Enter avata posts: ");
            post.setAvata(scanner.nextLine());
            System.out.println("Enter the posts content: ");
            post.setContent(scanner.nextLine());
            System.out.print("Enter the name of the author posts: ");
            post.setAuthor(scanner.nextLine());
            System.out.print("Enter day writes: ");
            post.setDayWrites(scanner.nextLine());
            listPost.add(post);
            i++;
            do {
                System.out.println("Do you want to continue to add posts (y / n)?");
                choose = scanner.nextLine();
                if (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n")) {
                    System.out.println("Improper manipulation request in again !!!");
                }
            } while ((!choose.equalsIgnoreCase("y")) && (!choose.equalsIgnoreCase("n")));
        }
        while (choose.equalsIgnoreCase("y"));
        return listPost;
    }

    private static void showListOfPosts(java.util.ArrayList<InformationPosts> postList) {
        System.out.println(String.format("\nLIST OF YOUR POSTS:"));
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------");
        for (int j = 0; j < postList.size(); j++) {
            InformationPosts post = (InformationPosts) postList.get(j);
            System.out.println(String.format("\nPOSTS %s: %s", j + 1, post.getTitle()));
            System.out.println(String.format("Code: %s  ||  Day writes: %s", post.getCode(), post.getDayWrites()));
            System.out.println(String.format("Avata: %s", post.getAvata()));
            System.out.println(String.format("Description: %s", post.getDescription()));
            System.out.println(String.format("Content:\n%s", post.getContent()));
            System.out.println(String.format("Author: %s", post.getAuthor()));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }

    private static boolean exitTheProgram() {
        System.out.print(String.format("\nGood bye see you again!!!"));
        return false;
    }

    private static void reEnterRequired() {
        System.out.print(String.format("\nOperation incorrect, requires re-enter!!!"));
    }
}
