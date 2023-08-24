package com;

import sorting.SortingAlgorithm;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        //int[] a = new int[]{102, 4, 100, 1, 101,99,103,98, 3, 2, 1, 1, 7, 2, 8, 1, 9};
        //int[] a = new int[]{10,1,7,2,8,9,3,4,5,11,12};
        //int[] a = new int[]{1, 6, 6, 5, 7, 4, 1, 6, 7, 6,6,6, 6, 6, 2};
        //int[] a= new int[]{2,2,7,3,2};
        //int[] a = new int[]{1, 5, -4, 7, 8, -6};
        //int[] a = new int[]{-21,-67,-37,-18,4,-65};
        //int[] a = new int[]{-8, -66, -60, 60};
        //int[] a = new int[]{0,1,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,1};
        //int[] a = new int[]{10, 20, 30, 40, 1, 2};
        //int[] a = new int[]{11,14,5,6,20,10,4,2};
        //int[] a = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //int[] a = new int[]{1, 2, -3, 4, -2, -1, 3};
        long[] a = new long[]{1,2,3,4,5,6};
        //int[] a = new int[]{12,25,32,40,7,9};
        //int[] a = new int[]{-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
        //int[] a = new int[]{100, 10, 90, 20, 80, 30, 70, 40, 60, 50};
        m.arrangeMaximumAndMinimumElement(a);
        /*String word="FlaG";
        System.out.println(m.detectCapitalRightUsage(word));*/
        //int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    }

    public void removeElementFromAnArray(int[] a, int x) {
        System.out.println(" Before removing element :- " + Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                int j = i;
                while (j < a.length - 1) {
                    a[j] = a[j + 1];
                    j++;
                }
                break;
            }
        }
        for (int k = 0; k < a.length - 1; k++) {
            System.out.print(a[k] + " ");
        }
    }

    //7,6,8,5,3,1 ==> 3 ==> 16
    public void insertElementAtSpecificPosition(int[] a, int element, int index) {
        System.out.println(" Before inserting element " + Arrays.toString(a));
        /*for (int i = 0; i < a.length; i++) {
            if (i == index) {
                int j = a.length-1;
                while (j>i){
                    a[j] = a[j-1];
                    j--;
                }
                a[i]=element;
                break;
            }
        }*/
        for (int i = a.length - 1; i > index - 1; i--) {
            a[i] = a[i - 1];
        }
        a[index] = element;
        System.out.println(" After Inserting element " + Arrays.toString(a));
    }

    public ArrayList<ArrayList<Integer>> interviewBitPractice(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    ;

    /**
     * first approach
     *
     * @param a
     * @param position
     */
    public void rotateArrayAntiClockWise(int[] a, int position) {
        System.out.println(" Before rotation " + Arrays.toString(a));
        for (int i = 0; i < position; i++) {
            int element = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = element;
        }
        System.out.println(" After rotation " + Arrays.toString(a));
    }

    public void rotateArrayWithBestApproachAntiClockWise(int[] a, int k) {
        System.out.println(" Before rotating " + Arrays.toString(a));
        k = k % a.length;
        reverseArray(a, 0, k - 1);
        reverseArray(a, k, a.length - 1);
        reverseArray(a, 0, a.length - 1);
        System.out.println(" After rotating " + Arrays.toString(a));
    }

    public void reverseArray(int[] a, int low, int high) {
        while (low < high) {
            new SortingAlgorithm().swapElement(a, low, high);
            low++;
            high--;
        }
    }

    public void findDuplicateValues(int[] a) {
        /**
         * first approach
         * O(n) -- time complexity , O(n) -- space complexity
         */
        /*Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            if (integerMap.containsKey(a[i])) {
                integerMap.put(a[i], integerMap.get(a[i]) + 1);
                continue;
            }
            integerMap.put(a[i], ++count);
        }
        System.out.println(" Map " + integerMap);*/
        /**
         * second approach
         * O(n2) -- time complexity , O(1) -- space complexity
         */
        /*for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]) {
                    System.out.println(" Duplicate element is " + a[i]);
                }
            }
        }*/
        /**
         * third approach :- it does not work with array contains negative intergers
         * O(n2) -- time complexity , O(n) -- space complexity
         */
        System.out.println(" Before finding duplicate " + Arrays.toString(a));
        /*int max = Integer.MIN_VALUE;
        for(int j=0;j<a.length;j++){
            if(a[j]>max){
                max=a[j];
            }
        }
        int[] temp = new int[max+1];
        for(int i=0;i<a.length;i++){
            temp[a[i]]++;
        }
        boolean duplicatePresent=false;
        for(int k = 0;k<temp.length;k++){
            if(temp[k]>1){
                duplicatePresent=true;
                System.out.println("Duplicate elements are "+k);
            }
        }
        if(!duplicatePresent){
            System.out.println(" Array does not contain any duplicate element ");
        }*/
        /**
         * fourth approach works on below conditions
         * a)1 <=a[i]<=n
         * b)array modification is allowed
         */
        Vector<Integer> integers = new Vector<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = a[i] % n;
            a[index] += n;
        }
        int count = 0;
        while (count < n) {
            int temp = a[count] / n;
            if (temp >= 2) {
                integers.add(count);
            }
            count++;
        }
        if (integers.isEmpty()) {
            System.out.println(" No duplicates in array ");
            return;
        }
        System.out.println(integers);
    }

    public Set<Integer> findCommonElement(int[] a, int[] b) {
        Set<Integer> commonElementList = new HashSet<>();

        if (a.length > b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (a[i] == b[j]) {
                        commonElementList.add(a[i]);
                    }
                }
            }
            if (commonElementList.isEmpty()) {
                System.out.println(" Both array does not have any common element ");
                return commonElementList;
            }
            System.out.println(" Common elements are " + commonElementList);
            return commonElementList;
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    commonElementList.add(b[i]);
                }
            }
        }
        if (commonElementList.isEmpty()) {
            System.out.println(" Both array does not have any common element ");
            return commonElementList;
        }
        System.out.println(" Common elements are " + commonElementList);
        return commonElementList;
    }

    public int[] removeDuplicateElement(int[] a) {
        /**
         * worst approach for removing duplicate elements
         */
        /*System.out.println(" Before removing duplicate "+Arrays.toString(a));
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++){
            boolean flag = false;
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]){
                 flag=true;
                 break;
                }
            }
            if(!flag)
                b[i]=a[i];
        }
        System.out.print(" After removing duplicate ");
        for(int k=0;k<b.length;k++){
            if(b[k]!=0){
                System.out.print(b[k]+" ");
            }
        }*/

        /**
         * second approach(80% similar to first approach)
         * Condition is Array should be sorted
         */
        /*System.out.println(" Before removing duplicate "+Arrays.toString(a));
        insertionSorting(a);
        int temp[] = new int[a.length];
        int j=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]!=a[i+1]){
                temp[j]=a[i];
                j++;
            }
        }
        temp[j]=a[a.length-1];
        System.out.println(" After removing duplicate "+Arrays.toString(temp));*/
        /**
         * third approach
         */
        System.out.println(" Before removing duplicate " + Arrays.toString(a));
        new SortingAlgorithm().insertionSorting(a);
        int j = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j] = a[i];
                j++;
            }
        }
        if (j == a.length - 1) {
            return a;
        }
        a[j] = a[a.length - 1];
        System.out.println(" After removing duplicate " + Arrays.toString(a));
        /*for (int i = 0; i <= j; i++) {
            System.out.println(a[i]);
        }*/
        int[] b = Arrays.copyOf(a, j);
        return b;
    }

    public void findSecondLargestElementInArray(int[] a) {
        /**
         * First approach
         * Basic approach (brut force)
         */
        /*System.out.println(" Array "+Arrays.toString(a));
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        System.out.println(" Largest element is "+max);

        int[] temp = new int[a.length];
        for(int i=0;i<a.length;i++){
            temp[i]=max-a[i];
        }
        int smallest=Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<temp.length;i++){
            if(temp[i]<smallest && temp[i]!=0){
                smallest=temp[i];
                index=i;
            }
        }
        System.out.println(" Second largest element is "+a[index]);*/
        /**
         * Second approach
         * sort the array and then find the second largest element
         */
       /* System.out.println(" Before sorting "+Arrays.toString(a));
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j=i-1;
            while(j>=0 && a[j]>temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
        System.out.println(" After sorting "+Arrays.toString(a));
       for(int k=a.length-1;k>=0;k--){
           if(a[k]!=a[k-1]){
               System.out.println(" Second largest element is "+a[k-1]);
               break;
           }
       }*/
        /**
         * third approach
         * using single iteration
         */
        System.out.println(" Array " + Arrays.toString(a));
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            }
            if (a[i] < largest && a[i] > secondLargest) {
                secondLargest = a[i];
            }
        }
        System.out.println(" Second largest is " + secondLargest);
    }

    public void addTwoMatriceOfSameSize(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printArrayInSpiralForm(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        List<Integer> integerList = new ArrayList<>();
        int n = a.length;
        int m = a[0].length;
        int left = 0, top = 0;
        int right = m - 1;
        int bottom = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                integerList.add(a[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                integerList.add(a[j][right]);
            }
            right--;
            if (top <= bottom) {
                for (int k = right; k >= left; k--) {
                    integerList.add(a[bottom][k]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int z = bottom; z >= top; z--) {
                    integerList.add(a[z][left]);
                }
                left++;
            }
        }
        System.out.println(integerList);
    }

    /**
     * Java program to find all pairs of elements in an array whose sum is equal to a specified number.
     *
     * @param a
     */
    public void findPairsEqualToNumber(int[] a, int x) {
        /**
         * first appraoch
         * brut force
         */
       /* for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]+a[j]==sum){
                    System.out.println(" Pair who sum is equal to "+sum+" is : "+a[i]+","+a[j]);
                }
            }
        }*/
        /**
         * Second approach
         * 2 pointer approach
         * Condition is array should be sorted
         */
        /*System.out.println("Array " + Arrays.toString(a));
        int j = a.length - 1;
        int i = 0;
        while (i <j) {
             if (a[i] + a[j] == sum) {
                System.out.println(" Pair who sum is equal to " + sum + " is : " + a[i] + "," + a[j]);
                i++;
                j--;
            } else if (a[i] + a[j] < sum) {
                i++;
            } else if (a[i] + a[j] > sum) {
                j--;
            }
        }*/
        /**
         * Third approach
         * using map
         */
        Map<Integer, Integer> integerMap = new HashMap<>();
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            if (integerMap.containsKey(a[i])) {
                integerMap.put(a[i], integerMap.get(a[i]) + 1);
                continue;
            }
            integerMap.put(a[i], count);
        }
        int pairs = 0;
        for (int j = 0; j < a.length; j++) {
            if (integerMap.containsKey(x - a[j])) {
                pairs++;
            }
        }
        System.out.println(" No of pairs who sum is " + x + " is " + pairs / 2);
    }

    public void findMissingNumberInArray(int[] a) {
        /**
         * Basic approach
         * my approach
         */
        /*int missingNumber =0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]+1==a[i+1]){
                continue;
            }
            missingNumber=a[i]+1;
            break;
        }
        System.out.println("Missing number is "+missingNumber);*/
        /**
         * Using smallest and largest element
         */

        /*int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int arraySum =0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
            } else if (a[i] > largest) {
                largest=a[i];
            }
            arraySum+=a[i];
        }
        int sum=0;
        for(int i=smallest;i<=largest;i++){
            sum+=i;
        }
        System.out.println(" Missing number is "+(sum-arraySum));*/
    }

    public void findCommonElementInTripleArray(int[] a, int[] b, int[] c) {
        /**
         * Basic approach
         */
        /*Set<Integer> integerSet = new HashSet<>();
        integerSet = findCommonElement(a,b);
        Set<Integer> newIntegerSet = new HashSet<>();
        Arrays.stream(c).forEach(newIntegerSet::add);
        if(integerSet.size() >= newIntegerSet.size()){
            integerSet.retainAll(newIntegerSet);
            System.out.println(" Common element in all array is "+integerSet);
            return;
        }
        newIntegerSet.retainAll(integerSet);
        System.out.println(" Common element in all array is "+newIntegerSet);*/
        Set<Integer> integerSet = new HashSet<>();
        int x = 0, y = 0, z = 0;
        while (x < a.length && y < b.length && z < c.length) {
            if (a[x] == b[y] && b[y] == c[z]) {
                integerSet.add(a[x]);
                x++;
                y++;
                z++;
            } else if (a[x] < b[y]) {
                x++;
            } else if (b[y] < c[z]) {
                y++;
            } else {
                z++;
            }
        }
        System.out.println(" Common element in all array is " + integerSet);
    }

    public void moveZeroToEndOfArray(int[] a) {
        /**
         * Basic and worst approach
         *
         */
        /*System.out.println(" Array before moving all 0's to end " + Arrays.toString(a));
        int count = 0;
        boolean isZeroPresent = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                isZeroPresent = true;
                count++;
            }
        }
        if (!isZeroPresent) {
            System.out.println(" Array does not contain any 0 elements ");
            return;
        }
        if (count == a.length) {
            System.out.println(" All elements are O so no need to move those at the end of array");
            return;
        }
        int[] b = new int[a.length];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                b[j] = a[i];
                j++;
            }
        }
        for (int i = a.length - 1; i >= (a.length - count); i--) {
            b[i] = 0;
        }
        System.out.println(" Array after moving all 0's to end " + Arrays.toString(b));*/
        /**
         * 2 pointer approach
         * Relative order of array is not maintained
         * This approach will work if array is in sorted order
         * Not so effective
         */
        /*int i=0,j=a.length-1;
        while(i < j){
            if(a[i]==0 && a[j]!=0){
                new SortingAlgorithm().swapElement(a,i,j);
                i++;
                j--;
            }
            else if(a[i]==0 && a[j]==0){
                j--;
            }
            else if(a[i]!=0 && a[j]!=0){
                i++;
               j--;
            }
            else if(a[i]!=0 && a[j]==0){
                j--;
            }
        }
        System.out.println(" Array after moving element "+Arrays.toString(a));*/

        /**
         * third approach
         * Move non-zero element to starting of array
         * move zero to end of array         */
        /*int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                a[count++]=a[i];
            }
        }
        while(count<a.length){
            a[count]=0;
            count++;
        }
        System.out.println("After moving 0's element to end of array "+Arrays.toString(a));*/
        /**
         * fourth approach
         */
        int nz = 0, z = 0;
        while (nz < a.length) {
            if (a[nz] == 0) {
                nz++;
            } else {
                new SortingAlgorithm().swapElement(a, nz, z);
                nz++;
                z++;
            }
        }
        System.out.println("After moving 0's element to end of array " + Arrays.toString(a));
    }

    public boolean checkArrayContainsOnlyZeroAndOne(int[] a) {
        /**
         * First approach
         */
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 || a[i] == -1) {
                return false;
            }
        }
        return true;
    }

    public void removeDuplicateElementsAndReturnUpdatedArrayLength(int[] a) {
        new SortingAlgorithm().insertionSorting(a);
        int j = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                continue;
            }
            a[j] = a[i];
            j++;
        }
        a[j] = a[a.length - 1];
        System.out.println(" After removing array " + Arrays.toString(a));
        System.out.println(" Updated length of array after removing duplicates is " + (j + 1));

    }

    public void findLongestConseElementSequence(int[] a) {
        /**
         * Brut force solution
         * Not working approach
         */

        /*int count;
        int longestCount = 1;
        for (int i = 0; i < a.length; i++) {
            int n = a[i];
            count = 1;
            while (linearSearch(a, n + 1)) {
                n = n + 1;
                count++;
                longestCount = max(longestCount, count);
            }
        }
        System.out.println(" Longest sequence count " + longestCount);*/
        /**
         * Second approach
         * Array should be sorted
         */
        /*System.out.println(" Array " + Arrays.toString(a));
        new SortingAlgorithm().insertionSorting(a);

        int count = 1;
        int longestConsecutive = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                continue;
            }
            if (a[i] + 1 == a[i + 1]) {
                count++;
                longestConsecutive = Math.max(count, longestConsecutive);
                continue;
            }
            count = 1;
        }
        System.out.println(" Longest consecutive sequence length " + longestConsecutive);*/
        /**
         * Third approach
         */
        /*Map<Integer,Boolean> hashMap = new HashMap<>();
        Arrays.stream(a).forEach(arr -> hashMap.put(arr,true));
        System.out.println(" Map before modification "+hashMap);
        hashMap.forEach((key1, value) -> {
            if (hashMap.containsKey(key1 - 1)) {
                hashMap.put(key1, false);
            }
        });
        System.out.println(" Map after modification "+hashMap);
        int count=1;
        int longestSequence=1;
        for(Map.Entry<Integer,Boolean> finalMap : hashMap.entrySet()){
            count=1;
            if(!finalMap.getValue()){
                continue;
            }
            if(!hashMap.containsKey(finalMap.getKey()+1)){
                continue;
            }
            int n=finalMap.getKey();
            while (hashMap.containsKey(n+1)){
                n=n+1;
                count++;
                longestSequence=Math.max(count,longestSequence);
            }
        }
        System.out.println(" Longest sequence "+longestSequence);*/
        /**
         * Fourth approach using HashSet
         */
        System.out.println(" Array " + Arrays.toString(a));
        /*int count = 1;
        int longestSequence = 1;
        HashSet<Integer> integerHashSet = new HashSet<>();
        Arrays.stream(a).forEach(integerHashSet::add);
        for (int i = 0; i < a.length; i++) {
            count = 1;
            if (integerHashSet.contains(a[i] - 1)) {
                continue;
            }
            int val = a[i];
            while (integerHashSet.contains(val + 1)) {
                val++;
                count++;
            }
            longestSequence = Math.max(longestSequence, count);

        }
        System.out.println(" Longest sequence " + longestSequence);*/
        /**
         * Fifth approach
         */
        int n = a.length;
        int maxLength = 1;
        int currLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1] + 1) {
                currLength++;
            } else {
                currLength = 1;
            }

            if (currLength > maxLength) {
                maxLength = currLength;
                endIndex = i;
            }
        }

        // Extract the longest sequence from the original array
        int[] longestSequence = new int[maxLength];
        for (int i = maxLength - 1; i >= 0; i--) {
            longestSequence[i] = a[endIndex - i];
        }
        System.out.println(" Longest sequence array " + Arrays.toString(longestSequence));
    }

    public boolean linearSearch(int[] a, int n) {
        return Arrays.stream(a).anyMatch(x -> x == n);
    }

    public void findTwoNumberEqualToThirdNumber(int[] a, int x) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        Arrays.stream(a).forEach(integerHashSet::add);
        for (int i : integerHashSet) {
            if (integerHashSet.contains(x - i)) {
                System.out.println(" Numbers are " + i + " and " + (x - i) + " whose sum is " + x);
                break;
            }
        }
    }

    void findTripletsSum(int[] a, int sum) {
        System.out.println(" Array is " + Arrays.toString(a));

        /**
         * Basic and brut force approach
         * Time complexity := O(n3)
         */
        /*for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                for(int k=j+1;k<a.length;k++){
                    if(a[i]==a[j] && a[j]==a[k]){
                        continue;
                    }
                    if(a[k]+a[j]+a[i]==sum){
                        System.out.println(" Distinct triplets whose sum is "+sum+" are :- "+a[i]+","+a[j]+","+a[k]);
                    }
                }
            }
        }*/
        /**
         * Second approach
         * 3 pointer approach
         * Condition is array should be sorted
         */
        /*new SortingAlgorithm().shellSorting(a);
        for (int k = 0; k < a.length; k++) {
            int targetSum = sum - a[k];
            int start = k + 1;
            int end = a.length - 1;
            while (start < end) {
                int newSum = a[start] + a[end];
                if (newSum == targetSum) {
                    listList.add(Arrays.asList(a[start], a[end], a[k]));
                    start++;
                    end--;
                } else if (newSum < targetSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }*/
        /**
         * Third approach
         * Using hashset
         */
        HashSet<Integer> integerHashSet = new HashSet<>();
        Set<Set<Integer>> listList = new HashSet<>();
        HashSet<Integer> sortedSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int thirdNum = sum - a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (integerHashSet.contains(thirdNum - a[j])) {
                    sortedSet = new HashSet<>();
                    sortedSet.add(a[i]);
                    sortedSet.add(a[j]);
                    sortedSet.add(thirdNum - a[j]);
                    listList.add(sortedSet);
                    continue;
                }
                integerHashSet.add(a[j]);
            }
        }
        System.out.println(listList);
    }

    private void printArrayInAntiDiagonalFormat(int[][] a) {
        int n = a.length;
        int numberOfDiagonals = 2 * n - 1;
        List<List<Integer>> listOfIntegerList = new ArrayList<>();
        for (int i = 0; i < numberOfDiagonals; i++) {
            listOfIntegerList.add(new ArrayList<>());
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                listOfIntegerList.get(i + j).add(a[i][j]);
            }
        }
        for (int i = 0; i < listOfIntegerList.size(); i++) {
            for (int j = 0; j < listOfIntegerList.get(i).size(); j++) {
                System.out.print(listOfIntegerList.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    void printArrayInDiagonalFormat(int[][] a) {
        int n = a.length;
        int numberOfDiagonals = 2 * n - 1;
        List<List<Integer>> listOfIntegerList = new ArrayList<>();
        for (int i = 0; i < numberOfDiagonals; i++) {
            listOfIntegerList.add(new ArrayList<>());
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                listOfIntegerList.get(i + j).add(a[j][i]);
            }
        }
        for (int i = 0; i < listOfIntegerList.size(); i++) {
            for (int j = 0; j < listOfIntegerList.get(i).size(); j++) {
                System.out.print(listOfIntegerList.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    private void findMajorityElementInArray(int[] a) {
        /**
         * Basic approach
         * Brut force
         */
        /*int index =0;
        int count;
        int majorityCount=1;

        for(int i =0;i<a.length;i++){
            count=1;
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    count++;
                }
            }
            majorityCount=Math.max(majorityCount,count);
            if(majorityCount>a.length/2){
                if(count>=majorityCount)
                         index=i;
            }
        }
        System.out.println(" Majority element is present at index "+index+" and element is "+a[index]);*/
        /**
         * Moore voting algorithm
         * {7,3,2,3,3};
         */
        int element = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                element = a[i];
            }
            if (element == a[i]) {
                count++;
            } else {
                count--;
            }
        }
        int elementCounter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                elementCounter++;
            }
        }
        if (elementCounter > a.length / 2) {
            System.out.println("Majority element is " + element);
            return;
        }
        System.out.println(" No majority element");
    }

    /**
     * An element is leader if it is greater than all the elements to its right side
     * {10, 58, 14, 23, 15, 0, 9};
     *
     * @param a
     */
    private void findLeaderElementInArray(int[] a) {
        /**
         * Basic Approach
         * Brut force solution
         */
        /*Stack<Integer> integerStack = new Stack<>();
        int count=0;
        boolean isGreater=true;
        for(int i=0;i<a.length;i++){
            isGreater=true;
            for(int j=i+1;j<a.length;j++){
                count++;
                if(a[i]<=a[j]){
                    isGreater=false;
                    break;
                }
            }
            if(isGreater){
                integerStack.push(a[i]);
            }
        }
        System.out.println(" Leaders element is array "+integerStack);
        System.out.println(count);*/
        /**
         * Second approach
         */
        int current_Leader = a[a.length - 1];
        System.out.println(current_Leader);
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > current_Leader) {
                current_Leader = a[i];
                System.out.println(current_Leader);
            }
        }
    }

    private int findSumCloseToZero(int[] a) {
        System.out.println(" Arrays " + Arrays.toString(a));
        /**
         * Basic approach
         * Brut force solution
         */
        /*if (a.length < 2) {
            System.out.println("Invalid array");
            return;
        }
        int lowestIndex = 0;
        int highestIndex = a.length - 1;
        int minimumSum = a[lowestIndex] + a[highestIndex];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                if (Math.abs(minimumSum) > Math.abs(sum)) {
                    minimumSum = sum;
                    lowestIndex = i;
                    highestIndex = j;
                }
            }
        }
        System.out.println(" Elements are "+a[lowestIndex]+","+a[highestIndex]);*/
        /**
         * Geeks for practice
         * not working for this input [-8, -66, -60, 60]
         */
        /*if(a.length==1){
            return 2*a[a.length-1];
        }
        for(int i=a.length-1;i>=0;i--){
            if(a[i]<0 && a[i-1]<0){
                return a[i]+a[i-1];
            }
            else{
                break;
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]>0 && a[i+1]>0){
                return a[i]+a[i+1];
            }
            else{
                break;
            }
        }
        int start=0,end=a.length-1;
        int minimumSum=a[start]+a[end];
        int i=0,j=a.length-1;
        while(i<j){
            int sum=a[i]+a[j];
            if(Math.abs(minimumSum)>Math.abs(sum)){
                minimumSum=sum;
                j--;
            }
            else if(Math.abs(minimumSum)<Math.abs(sum)){
                i++;
            }
            else {
                i++;
                j--;
            }
        }
        return minimumSum;*/
        /**
         * Third approach
         */
        int minimumSum = Integer.MAX_VALUE;
        new SortingAlgorithm().shellSorting(a);
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int sum = a[start] + a[end];
            if (Math.abs(sum) < Math.abs(minimumSum)) {
                minimumSum = sum;
            }
            if (Math.abs(sum) == Math.abs(minimumSum)) {
                minimumSum = Math.max(minimumSum, sum);
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }

        }
        return minimumSum;
    }

    private void findSmallestAndSecondSmallest(int[] a) {
        /**
         * Noob approach
         * first approach
         * Brut force approach
         */
        /*new SortingAlgorithm().shellSorting(a);
        for(int i=0;i<a.length;i++){
            if(a[i]!=a[i+1]){
                System.out.println(" Smallest is "+a[i]+",Second smallest is "+a[i+1]);
                break;
            }
        }*/
        /**
         * Second approach
         */
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            }
            if (a[i] > smallest && a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
        }
        System.out.println(" Smallest is " + smallest + ",Second smallest is " + secondSmallest);
    }

    private void separateZeroAndOneElements(int[] a) {
        /**
         * Basic approach
         * Brut force
         * nlog(N) approach
         */
        /*new SortingAlgorithm().shellSorting(a);
        System.out.println(" Array "+Arrays.toString(a));*/
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            if (a[start] != 0 && a[end] != 1) {
                new SortingAlgorithm().swapElement(a, start, end);
            }
            if (a[start] == 0) {
                start++;
            }
            if (a[end] == 1) {
                end--;
            }
        }
        System.out.println(" Array " + Arrays.toString(a));
    }

    private void findAllFourElementsSumElement(int[] a, int target) {
        /**
         * O(n3)
         */
        /*new SortingAlgorithm().shellSorting(a);
        System.out.println(" Array "+Arrays.toString(a));
        List<List<Integer>> quadrapleList = new ArrayList<>();
        int n=a.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int targetSum = sum -(a[i]+a[j]);
                int start = j+1;
                int end=a.length-1;
                while(start<end){
                    int result = a[start]+a[end];
                    if(result == targetSum){
                        quadrapleList.add(List.of(a[i],a[j],a[start],a[end]));
                        end--;
                        start++;
                    }
                    else if(result>targetSum){
                        end--;
                    }
                    else{
                        start++;
                    }
                }
            }
        }
        System.out.println(quadrapleList);*/
        /**
         * O(n2)
         */
        new SortingAlgorithm().shellSorting(a);
        List<List<Integer>> quadrapleList = new ArrayList<>();
        Map<Integer, List<int[]>> sumPairs = new HashMap<>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                int[] pair = {i, j};

                if (!sumPairs.containsKey(sum)) {
                    sumPairs.put(sum, new ArrayList<>());
                }
                sumPairs.get(sum).add(pair);
            }
        }

        // Check for all possible pairs of elements
        for (int i = 0; i < a.length - 3; i++) {
            for (int j = i + 1; j < a.length - 2; j++) {
                int remainingSum = target - a[i] - a[j];

                if (sumPairs.containsKey(remainingSum)) {
                    for (int[] pair : sumPairs.get(remainingSum)) {
                        if (pair[0] > j) {
                            List<Integer> quadruple = new ArrayList<>();
                            quadruple.add(a[i]);
                            quadruple.add(a[j]);
                            quadruple.add(a[pair[0]]);
                            quadruple.add(a[pair[1]]);
                            quadrapleList.add(quadruple);
                        }
                    }
                }
            }
        }
        System.out.println(quadrapleList);
    }

    private void countPossibleTriangleInArray(int[] a) {
        System.out.println(" Array " + Arrays.toString(a));
        new SortingAlgorithm().shellSorting(a);
        int count = 0;
        for (int k = a.length - 1; k >= 0; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (a[i] + a[j] >= a[k]) {
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    count = count + (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        System.out.println(count);
    }

    public void rotateArrayClockWise(int[] a, int x) {
        /*System.out.println(" Before rotation "+Arrays.toString(a));
        for(int i=0;i<x;i++){
            int temp =a[a.length-1];
            for(int j=a.length-2;j>=0;j--){
                a[j+1]=a[j];
            }
            a[0]=temp;
        }
        System.out.println(" After rotation "+Arrays.toString(a));*/
        /**
         * Second approach
         */

        System.out.println(" Before rotating " + Arrays.toString(a));
        x = x % a.length;
        reverseArray(a, a.length - x, a.length - 1);
        reverseArray(a, 0, a.length - 1 - x);
        reverseArray(a, 0, a.length - 1);
        System.out.println(" After rotating " + Arrays.toString(a));
    }

    public boolean sumPairs(int[] arr, int x, int n) {
        /**
         * First approach
         * O(N)
         * O(N)
         */
        /*Map<Integer,Integer> integerMap = new HashMap<>();
        int count=1;
        for(int i=0;i<a.length;i++){
            if(integerMap.containsKey(a[i])){
                integerMap.put(a[i],integerMap.get(a[i])+1);
            }
            else{
                integerMap.put(a[i],count);
            }
        }
        for(int i=0;i<a.length;i++){
            if(integerMap.containsKey(sum-a[i])){
                return true;
            }
        }
        return false;*/
        /**
         * Second approach
         */
        // Find the pivot element
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        // l is now index of smallest element
        int l = (i + 1) % n;

        // r is now index of largest element
        int r = i;

        // Keep moving either l or r till they meet
        while (l != r) {
            // If we find a pair with sum x, we
            // return true
            if (arr[l] + arr[r] == x)
                return true;

            // If current pair sum is less, move
            // to the higher sum
            if (arr[l] + arr[r] < x)
                l = (l + 1) % n;

                // Move to the lower sum side
            else
                r = (n + r - 1) % n;
        }
        return false;
    }

    public void findRotationInRotatedSortedArray(int[] a) {
        /**
         * First approach
         *Not sure on below approach
         */
        /*int count=1;
        for(int i=0;i<a.length-1;i++){
            if(a[i]<a[i+1]){
                count++;
            }
            else{
                break;
            }
        }
        if(count==a.length){
            System.out.println(" Array is not rotated");
            return;
        }
        System.out.println(" Array is rotated by "+count+" times");*/
        /**
         * Second approach
         * Find minimum element and return its index
         */
        /*int min_value=a[0];
        int min_index=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]<min_value){
                min_value=a[i];
                min_index=i;
            }
        }
        System.out.println("Array is rotated by "+min_index+" times");*/
        /**
         * Using binary search
         */
        int n = a.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            if (a[mid] < a[prev] && a[mid] < a[next]) {
                System.out.println(" No of rotation are " + mid + " and minimum element is " + a[mid]);
                return;
            }
            if (a[start] <= a[mid]) {
                start = mid + 1;
            }
            if (a[mid] <= a[end]) {
                end = mid - 1;
            }
        }
    }

    public void arrangePositiveAndNegativeIntegers(int[] a) {
        /**
         * First array
         * but array is getting modified
         */
        System.out.println(" Before shifting " + Arrays.toString(a));
        int start = 0, end = a.length - 1;
        while (start <= end) {
            if (a[start] > 0) {
                start++;
            } else if (a[end] < 0) {
                end--;
            } else if (a[start] < 0 && a[end] > 0) {
                new SortingAlgorithm().swapElement(a, start, end);
                start++;
                end--;
            }
        }
        System.out.println(" After shifting " + Arrays.toString(a));
    }

    /**
     * Leet code
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     * <p>
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital, like "Google".
     * Given a string word, return true if the usage of capitals in it is right.
     *
     * @param word
     */
    public boolean detectCapitalRightUsage(String word) {

        char[] a = word.toCharArray();
        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        for (char c : a) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            }
        }
        if (lowerCaseCount == word.length() || upperCaseCount == word.length()) {
            return true;
        } else if (lowerCaseCount == word.length() - 1 && Character.isUpperCase(a[0])) {
            return true;
        }
        return false;
    }

    /**
     * Write a Java program to sort an array of positive integers from an array.
     * In the sorted array the value of the first element should be maximum,
     * the second value should be a minimum,
     * third should be the second maximum,
     * the fourth should be the second minimum and so on.
     *
     * @param a
     */
    public void arrangeMaximumAndMinimumElement(long[] a) {
        /**
         * Working
         * Brut force
         * worst code
         * not working for large number of inputs
         * works for un sorted array also
         */
        /*System.out.println(" Before arranging " + Arrays.toString(a));
        Set<Integer> integerSet = new HashSet<>();
        Arrays.stream(a).forEach(integerSet::add);
        int i = 0;

        while (i < a.length - 1) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            boolean minFlag = false;
            boolean maxFlag = false;
            for (int element : integerSet) {
                if (element < min) {
                    minFlag = true;
                    min = element;
                }
                if (element > max) {
                    maxFlag = true;
                    max = element;
                }
            }
            if (maxFlag)
                integerSet.remove(max);
            if (minFlag)
                integerSet.remove(min);
            if (!integerSet.contains(max) && !integerSet.contains(min)) {
                a[i] = max;
                a[i + 1] = min;
            }
            i=i+2;
        }
        for(int set : integerSet){
            a[a.length-1]=set;
        }

        System.out.println(" after arranging " + Arrays.toString(a));*/

        /**
         * Condition is array should be sorted
         */
        /*int max = arr.length-1;
        int min = 0;
        boolean flag = true;
        long temp[] = new long[arr.length];
        for(int i=0;i<arr.length;i++){
            if(flag) {
                temp[i]=arr[Math.toIntExact(Long.valueOf(max--))];
            }
            else {
                flag=true;
                temp[i]=arr[min++];
                continue;
            }
            flag=false;
        }
        for(int i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }*/
        //System.out.println(" After arranging "+Arrays.toString(temp));
        /**
         * Third apporach
         * Time complexity = O(n)
         * Space complexity =O(N)
         */
        System.out.println(" Original array "+Arrays.toString(a));
        long temp[]  = new long[a.length];
         int maxPointer=a.length-1;
         int minPointer=0;
         int index =0;
         while (minPointer<maxPointer){
             temp[index]=a[maxPointer];
             temp[index+1]=a[minPointer];
             minPointer++;
             index=index+2;
             maxPointer--;
         }
        System.out.println(" After arranging "+Arrays.toString(temp));
    }

}