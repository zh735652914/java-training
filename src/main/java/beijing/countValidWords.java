package beijing;
/*
https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/
 */

public class countValidWords {
    static class Solution {
        public int countValidWords(String sentence) {
            int ans = 0;
            int L = 0, R = 0;
            while (L < sentence.length()) {
                while (L < sentence.length() && sentence.charAt(L) == ' ') {
                    L++;
                }
                if (L >= sentence.length()) {
                    break;
                }
                R = L + 1;
                while (R < sentence.length() && sentence.charAt(R) != ' ') {
                    R++;
                }
                if (isValid(sentence.substring(L, R))) {
                    ans++;
                }
                L = R + 1;
            }
            return ans;
        }

        private boolean isValid(String word) {
            boolean hasHyphens = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                    return false;
                } else if (word.charAt(i) == '-') {
                    if (hasHyphens || i == 0 || i == word.length() - 1 || !Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                        return false;
                    }
                    hasHyphens = true;
                } else if (word.charAt(i) == '!' || word.charAt(i) == ',' || word.charAt(i) == '.') {
                    if (i != word.length() - 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String sentence = "p ypuou5!w7-3 .l.- jfw 7 xhb3 t     ww8 jq p l3d n 8rb rzcx  1e, 1g cs2 ls8wapk-6,tyc. yvj-bfq   mrh9xd8t 0b12 k  js339   iinhx,tv t7 c3d.f pm,k1ju ilo a30 l aup..ckv g mzk6d ! 4, g!vl.od0sej0 u69mm 11 vsage1 q!6,n.1srh4uv6f4cgj7ri x,s  9h  htv a d!  yd29y   ktx y de.3m e 8zwmb r 1 7 x bc-   mgwgx1q- hl3w  l  eaw7b0ck  u 0i b r404 k0  obwbv  -s  5a hdy yb!zv h35t5zbp   gy lg0 7   !61p ca- t m6m-s  rrbwnr kri2 7n ta88a33zx ..2oe ,  2b e g50m 73m8o g 1 r ssgk  a .. -d- 8rexj.q !o-  8 i 2nflj2j2sy1q w a yynt vb 53zo2wx p nz   0 -2-ko up7d6w od yq ! za zgkn-4p 3b7rho 9 1v     n h ih -!o.sc4t35say-ynpj  2 6mgzs i12 , ofi .72  bx 9 r0.!uvz vt- nj0u5,5pj9 -20o5mtv1i  6 5b i 9np4cu 02g 6   ek, !re  0  tkdk r  pc3 -8 gn nc6- lr t0-3jafq9-t e h 3fmgbq  rt i.8 n edi5oot23 gubel4   pw  17 q nn- h 4buop!vt! 9gi1t5- .2s6ov31ds  82o78hb n4v  j.   w0 xu7rtcmd82  8rr.le kf  7q49wbpp- oe1!xjrv5a83yi1z9f4 j r hr7.plhc qshlc7n8xzmewib6 z o-d  44x9 p-dkps  h-9j p h3 n 3q1 y  0 u  g37vge   ";
        System.out.println(new Solution().countValidWords(sentence));
    }
}
