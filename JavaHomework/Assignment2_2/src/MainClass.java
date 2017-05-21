import java.util.Scanner;

/**
 * Created by juny on 2017. 5. 20..
 */
public class MainClass {
    public static void main(String[] args) {
        String cmd;
        String now_root = "C:", now_directory = "C";
        boolean founded;
        Scanner scanner = new Scanner(System.in);
        TreeNode nowNode;
        TreeNode treeNode = new TreeNode(null, now_directory);

        nowNode = treeNode;

        System.out.println("*****파일 탐색 프로그램*****");
        System.out.println("------------------------");
        System.out.println("md : 디렉토리 생성");
        System.out.println("rd : 디렉토리 삭제");
        System.out.println("cd : 디렉토리 변경");
        System.out.println("mf : 파일 생성");
        System.out.println("del : 파일 삭제");
        System.out.println("dir : 디렉토리 목록 출력");
        System.out.println("cd.. : 상위 폴더로 이동");
        System.out.println("------------------------");

        System.out.printf("C:/>");

        // TODO 현재 들어가 있는 디렉토리를 알아야 한다.
        // TODO 하나의 디렉토리 안에 여러가지의 파일을 포함할 수 있어야 한다.
        while(true) {
            founded = false;
            cmd = scanner.next();
            if(cmd.equals("md")) { // 디렉토리 생성
                String name;
                name = scanner.next();

                nowNode.setChildren(nowNode, name);

                System.out.println(name + " directory is created.");
                if(nowNode.getDirectory_name().equals("C"))
                    System.out.printf("C:/>");
                else
                    System.out.printf(now_root + ">");

            } else if(cmd.equals("rd")) { // 디렉토리 삭제
                String name;
                name = scanner.next();

                for (int i=0; i<nowNode.getChildren().size(); i++) {
                    if(nowNode.getChildren().get(i).getDirectory_name().equals(name)) {
                        nowNode.getChildren().remove(i);
                        founded = true;
                        break;
                    }
                }
                if(founded)
                    System.out.println(name + " directory is deleted");
                else
                    System.out.println(name + " directory is not Founded");
                System.out.printf(now_root + ">");

            } else if(cmd.equals("cd")) { // 디렉토리 변경
                String name;
                name = scanner.next();

                for (int i=0; i<nowNode.getChildren().size(); i++) {
                    if(nowNode.getChildren().get(i).getDirectory_name().equals(name)) {
                        nowNode = nowNode.getChildren().get(i);
                        now_root += "/" + name;
                        now_directory = name;
                        founded = true;
                        break;
                    }
                }
                if(!founded)
                    System.out.println(name + " directory is not Founded");
                System.out.printf(now_root + ">");

            } else if(cmd.equals("mf")) { // 파일 추가
                String name, type;
                int size;
                System.out.printf("++ File name : ");
                name = scanner.next();
                try {
                    System.out.printf("++ File size(bytes) : ");
                    size = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("wrong input!!");
                    System.out.printf(now_root + ">");
                    scanner.nextLine();
                    continue;
                }
                System.out.printf("++ File type : ");
                type = scanner.next();

                nowNode.setFiles(new File(now_directory, name, type, size));
                System.out.println(name + " file is created.");
                System.out.printf(now_root + ">");

            } else if(cmd.equals("del")) { // 파일 삭제
                System.out.printf("++ File name : ");
                String name;
                name = scanner.next();

                for (int i=0; i<nowNode.getFiles().size(); i++) {
                    if(nowNode.getFiles().get(i).getName().equals(name)) {
                        nowNode.getFiles().remove(i);
                        founded = true;
                        break;
                    }
                }
                if(founded)
                    System.out.println(name + " file is deleted");
                else
                    System.out.println(name + " file is not founded");
                System.out.printf(now_root + ">");

            } else if(cmd.equals("dir")) { // 디렉토리 목록 출력
                nowNode.printTree(nowNode);
                System.out.printf(now_root + ">");

            } else if(cmd.equals("cd..")) {
                if(!nowNode.getDirectory_name().equals("C")) {
                    nowNode = nowNode.getParent();
                    now_root = now_root.replace("/" + now_directory, "");
                    now_directory = nowNode.getDirectory_name();
                }
                System.out.printf(now_root + ">");

            } else {
                System.out.println("Did not find commend.");
                System.out.println("------------------------");
                System.out.println("md : 디렉토리 생성");
                System.out.println("rd : 디렉토리 삭제");
                System.out.println("cd : 디렉토리 변경");
                System.out.println("mf : 파일 생성");
                System.out.println("del : 파일 삭제");
                System.out.println("dir : 디렉토리 목록 출력");
                System.out.println("cd.. : 상위 폴더로 이동");
                System.out.println("------------------------");
                System.out.printf(now_root + ">");
            }
        }
    }
}