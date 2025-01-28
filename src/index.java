public class index {

    public static void main(String[] args) {

        int[] arr1 = { 10, 20, 25, 28, 30, 45, 50 };
        int[] arr2 = { 22, 27, 30, 55, 60, 80, 100 };

        int[] res = new int[arr1.length + arr2.length];

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length) {

            if (arr1[p1] <= arr2[p2]) {
                res[p3] = arr1[p1];
                p1++;
                p3++;
            } else {
                res[p3] = arr2[p2];
                p2++;
                p3++;
            }
        }

        while(p2<arr2.length){
            res[p3]=arr2[p2];
            p2++;
            p3++;
        }
        while(p1<arr1.length){
            res[p3]=arr2[p1];
            p1++;
            p3++;
        }

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

}
