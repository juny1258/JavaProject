import com.sun.corba.se.pept.transport.ContactInfoList;

import java.util.ArrayList;

/**
 * Created by juny on 2017. 5. 21..
 */
public class TreeNode {
    private TreeNode parent;
    private String directory_name;
    private ArrayList<File> files = new ArrayList<>();
    private ArrayList<TreeNode> Children = new ArrayList<>();

    TreeNode(TreeNode p, String dn) {
        parent = p;
        directory_name = dn;
    }

    public TreeNode getParent() {
        return parent;
    }

    public String getDirectory_name() {
        return directory_name;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(File file) {
        files.add(file);
    }

    public ArrayList<TreeNode> getChildren() {
        return Children;
    }

    public void setChildren(TreeNode parent, String directory_name) {
        Children.add(new TreeNode(parent, directory_name));
    }

    public void printTree(TreeNode root){

        for(int i = 0; i < root.Children.size(); i++){  //child 순회
            System.out.println("[Dir]   " + root.Children.get(i).directory_name);
        }

        for(int i = 0; i < root.files.size(); i++){  //child 순회
            root.files.get(i).printFile();
        }

    }

}
