    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package cse321_assignment_06_17101379;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.StringTokenizer;

    /**
     *
     * @author M S A
     */
    public class Bankers_Algorithm {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            BufferedReader Obj = null;
            try {
                String str;
                FileReader fR = new FileReader("banker's_algorithm.txt");
                Obj = new BufferedReader(fR);
                str = Obj.readLine();
                int P = Integer.parseInt(str);

                str = Obj.readLine();
                int R = Integer.parseInt(str);

                int[][] Maximum = new int[P][R];
                int[] Available_Resource = new int[R];
                int[][] Allocation = new int[P][R];
                int[][] Available = new int[P][R];
                int[][] Need = new int[P][R];
                char[] Seq = new char[P];
                boolean[] f = new boolean[R];

                str = Obj.readLine();
                for (int i = 0; i < P; i++) {
                    str = Obj.readLine();

                    StringTokenizer st = new StringTokenizer(str, " ");
                    for (int j = 0; j < R; j++) {
                        Maximum[i][j] = Integer.parseInt(st.nextToken());

                    }
                }
                str = Obj.readLine();

                for (int i = 0; i < P; i++) {
                    str = Obj.readLine();

                    StringTokenizer st = new StringTokenizer(str, " ");
                    for (int j = 0; j < R; j++) {
                        Allocation[i][j] = Integer.parseInt(st.nextToken());

                    }
                }

                str = Obj.readLine();
                str = Obj.readLine();

                StringTokenizer st = new StringTokenizer(str, " ");
                for (int j = 0; j < R; j++) {
                    Available_Resource[j] = Integer.parseInt(st.nextToken());
                }

                System.out.println("Need Matrix:");
                for (int i = 0; i < P; i++) {
                    for (int j = 0; j < R; j++) {
                        Need[i][j] = Maximum[i][j] - Allocation[i][j];
                        System.out.print(Need[i][j] + " ");
                    }
                    System.out.println();

                }
                int c = 0;
                for (int k = 0; k < P; k++) {
                    for (int i = 0; i < P; i++) {
                        int count = 0;
                        if (f[i] == false) {
                            for (int j = 0; j < R; j++) {
                                if (Need[i][j] > Available_Resource[j]) {
                                    break;
                                } else {
                                    count++;

                                }
                            }

                        }
                        if (count == R) {

                            for (int j = 0; j < R; j++) {
                                Available_Resource[j] = Available_Resource[j] + Allocation[i][j];
                                Available[c][j] = Available_Resource[j];
                            }

                            f[i] = true;

                            int x = (i + 65);
                            char ch = (char) x;
                            Seq[c] = ch;
                            c++;

                        }

                    }
                }
                System.out.println("Safe sequence is: ");
                for (int i = 0; i < P; i++) {

                    System.out.print(Seq[i] + " ");
                }
                System.out.println();
                System.out.println("Change in available resource matrix: ");
                for (int i = 0; i < P; i++) {

                    for (int j = 0; j < R; j++) {
                        System.out.print(Available[i][j] + " ");

                    }
                    System.out.println();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }
        }


    }
