// import java.util.*;

// public class RoomAllocation {
//     static Scanner scn = new Scanner(System.in);

//     public static void solve() {
//         return;
//     }

//     public static class pair {
//         int val;
//         int idx;

//         pair(int val, int idx)
//         {
//             this.val = val;
//             this.idx = idx;
//         }             
//     }
//     public static void main(String[] args) {
//         int n = scn.nextInt();
//         int[][] arr= new int[n][3];

//         for(int i=0; i<n; i++)
//         {
//             arr[i][0] = scn.nextInt();
//             arr[i][1] = scn.nextInt();
//             arr[i][2] = i+1;
//         }
                
//         Arrays.sort(arr, new Comparator<int[]>() {
//             public int compare(int[] a, int[] b) {
//                 return Double.compare(a[0], b[0]);
//             }
//         });
//         HashMap<Integer, pair> hmap = new HashMap<>();
//         PriorityQueue<pair> pq = new PriorityQueue<>(
// 			// order rooms by departure
// 			Comparator.comparingInt(r -> r.val)
// 		);
//         // for(int i=0; i<n; i++)
//         // {
//         //     System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
//         // }
//         int count = 1;
//         ArrayList<pair> ans = new ArrayList<>();
//         // hmap.put(1, new pair(arr[0][1],arr[0][2]));
        
//         ans.add(new pair(1,arr[0][2]));
//         pq.add(new pair(arr[0][1],1));
        
//         int s = pq.size();
//         for(int i=1; i<n; i++)
//         {                        
//             int arvl = arr[i][0];
//             int dep = arr[i][1]; 
//             pair mindep = pq.peek();                       
            
//             if(arvl > mindep.val)
//             {
//                 pq.remove();
//                 ans.add(new pair(mindep.idx, arr[i][2]));
//                 pq.add(new pair(dep,mindep.idx));
                
//             }
//             else
//             {
//                 count += 1;                
//                 pq.add(new pair(dep,count));
//                 ans.add(new pair(count, arr[i][2]));
//             }
//             s = Math.max(s, pq.size());
//         }
//         System.out.println(s);

        
//         int[][] narr= new int[n][2];
//         // for (int i = 0; i < n; i++) {
//         //     System.out.print(ans.get(i).idx + " ");
//         // }
//         // System.out.println();
//         // for (int i = 0; i < n; i++) {
//         //     System.out.print(ans.get(i).val + " ");
//         // }
//         for(int i=0; i<n; i++)
//         {
//             narr[i][0] = ans.get(i).val;
//             narr[i][1] = ans.get(i).idx;
//         }

//         Arrays.sort(narr, new Comparator<int[]>() {
//             public int compare(int[] a, int[] b) {
//                 return Double.compare(a[1], b[1]);
//             }
//         });

//         // System.out.println();
//         for(int i=0; i<n; i++)
//         {
//             System.out.print(narr[i][0] + " ");
//         }


//     }
// }



import java.util.*;

public class RoomAllocation {
    public static void main(String[] args) {
        // FastIO io = new FastIO();
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        Customer[] customers = new Customer[n];
        for (int i = 0; i < n; i++) {
            int arrival = io.nextInt();
            int departure = io.nextInt();
            customers[i] = new Customer(arrival, departure, i);
        }

        // sort customers by arrival time
        Arrays.sort(customers, Comparator.comparingInt(c -> c.arrival));

        PriorityQueue<Room> pq = new PriorityQueue<>(
                // order rooms by departure
                Comparator.comparingInt(r -> r.departure));

        int k = 0;
        // the room numbers allocated to each customer
        int[] roomAllocations = new int[n];
        // the number of the last new room we've allocated
        int lastRoom = 1;

        // add the first customer to the priority queue
        pq.add(new Room(customers[0].departure, lastRoom));
        roomAllocations[customers[0].index] = lastRoom;

        for (int i = 1; i < n; i++) {
            // find the minimum departure time
            Room min = pq.peek();

            if (min.departure < customers[i].arrival) {
                pq.remove();
                pq.add(new Room(customers[i].departure, min.number));
                roomAllocations[customers[i].index] = min.number;
            } else {
                lastRoom++;
                pq.add(new Room(customers[i].departure, lastRoom));
                roomAllocations[customers[i].index] = lastRoom;
            }
            k = Math.max(k, pq.size());
        }

        // io.println(k);
        System.out.println(k);
        // use StringBuilder to speed up output
        StringBuilder str = new StringBuilder();
        for (int allocation : roomAllocations) {
            str.append(allocation).append(" ");
        }
        // io.println(str);
        System.out.println(str);
        io.close();
    }

    static class Customer {
        int arrival, departure, index;

        Customer(int arrival, int departure, int index) {
            this.arrival = arrival;
            this.departure = departure;
            this.index = index;
        }
    }

    static class Room {
        // departure: the time that the customer occupying the room leaves
        // number: the number of the room
        int departure, number;

        Room(int departure, int number) {
            this.departure = departure;
            this.number = number;
        }
    }

    // BeginCodeSnip{FastIO}
    // class FastIO extends PrintWriter {
    //     private InputStream stream;
    //     private byte[] buf = new byte[1 << 16];
    //     private int curChar, numChars;

    //     // standard input
    //     public FastIO() {
    //         this(System.in, System.out);
    //     }

    //     public FastIO(InputStream i, OutputStream o) {
    //         super(o);
    //         stream = i;
    //     }

    //     // file input
    //     public FastIO(String i, String o) throws IOException {
    //         super(new FileWriter(o));
    //         stream = new FileInputStream(i);
    //     }

    //     // throws InputMismatchException() if previously detected end of file
    //     private int nextByte() {
    //         if (numChars == -1)
    //             throw new InputMismatchException();
    //         if (curChar >= numChars) {
    //             curChar = 0;
    //             try {
    //                 numChars = stream.read(buf);
    //             } catch (IOException e) {
    //                 throw new InputMismatchException();
    //             }
    //             if (numChars == -1)
    //                 return -1; // end of file
    //         }
    //         return buf[curChar++];
    //     }

    //     // to read in entire lines, replace c <= ' '
    //     // with a function that checks whether c is a line break
    //     public String next() {
    //         int c;
    //         do {
    //             c = nextByte();
    //         } while (c <= ' ');
    //         StringBuilder res = new StringBuilder();
    //         do {
    //             res.appendCodePoint(c);
    //             c = nextByte();
    //         } while (c > ' ');
    //         return res.toString();
    //     }

    //     public int nextInt() { // nextLong() would be implemented similarly
    //         int c;
    //         do {
    //             c = nextByte();
    //         } while (c <= ' ');
    //         int sgn = 1;
    //         if (c == '-') {
    //             sgn = -1;
    //             c = nextByte();
    //         }
    //         int res = 0;
    //         do {
    //             if (c < '0' || c > '9')
    //                 throw new InputMismatchException();
    //             res = 10 * res + c - '0';
    //             c = nextByte();
    //         } while (c > ' ');
    //         return res * sgn;
    //     }

    //     public double nextDouble() {
    //         return Double.parseDouble(next());
    //     }
    // }
    // EndCodeSnip
}