package LeetCode;

import java.util.Stack;

/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */
class SimplifyPathSolution {
    public String simplifyPath(String path) {
        Stack<String> S = new Stack<>();
        String[] P = path.split("/");
        for (int i = 0; i < P.length; i++) {
            if (P[i].equals("..") && !S.empty()) S.pop();
            if (!P[i].equals(".") && !P[i].equals("..") && !P[i].equals("")) S.push(P[i]);
        }

        if (S.empty()) return "/";
        String canonicalPath = "";
        Stack<String> T = new Stack<>();
        while (!S.empty()) {
            T.push(S.pop());
        }
        while (!T.empty()) {
            canonicalPath += "/";
            canonicalPath += T.pop();
        }
//        if (T.empty()) return "/";
        return canonicalPath;
    }
}

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPathSolution SP = new SimplifyPathSolution();
//        String path = "/../";
        String path = "/a/./b/../../../c/";
//        String path = "/...";
        System.out.println(SP.simplifyPath(path));
    }
}
