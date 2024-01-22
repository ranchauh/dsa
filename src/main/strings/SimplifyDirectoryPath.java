package strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 */
public class SimplifyDirectoryPath {

    public String simplifyPath(String path) {
        List<String> nodeList = new ArrayList<>();
        int p1 = 0;
        int p2 = 1;
        while(p2<path.length()) {
            char ch = path.charAt(p2);
            if(ch == '/') {
                handleNode(path, p1, p2, nodeList);
                p1 = p2;
            }
            p2++;
        }
        // handle last node without a /
        handleNode(path, p1, p2, nodeList);

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        System.out.println(nodeList.toString());
        Iterator<String> it = nodeList.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()) sb.append("/");
        }
        return sb.toString();
    }

    void handleNode(String path, int p1, int p2, List<String> nodeList) {
        String sub = path.substring(p1+1, p2);
        if("".equals(sub) || ".".equals(sub)) {
            // do nothing
        } else if("..".equals(sub)) {
            // remove last node to back
            if(nodeList.size() > 0)
                nodeList.remove(nodeList.size()-1);
        } else {
            nodeList.add(sub);
        }
    }
}
