package Beijing;

public class interview {
    private static interview uniqueInstance;

    public static void getUniqueInstance() {
//        if (uniqueInstance == null) {
//            uniqueInstance = new interview();
//        }
//        return uniqueInstance;


        int mid = 1;

        char[] A = {'a', 'b', 'd', 'e'};
        char[] B = {'a', 'b', 'c', 'd', 'e'};
//        char[] A = {};
//        char[] B = {'e'};

//        A[mid] > B[mid] // ans   right=mid;
//        A[mid] == B[mid] //      left=mid+1;

        //  A[mid]>B[mid]

        int left = 0, right = B.length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (A[mid] > B[mid]) {
                right = mid;
            } else if (A[mid] == B[mid]) {
                left = mid + 1;
            }
        }
        System.out.println(B[left]);

    }

    public static void main(String[] args) {
        getUniqueInstance();
    }
    /*

     */
}
