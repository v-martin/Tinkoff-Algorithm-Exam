import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class taskFour {


    static class Node {
        public Node parent ;
        public int value;
        public int length;
        public int id;
        public int load = 0;


        public Node(int value, int length, int id) {
            this.value = value;
            this.length = length;
            this.id = id;
        }

        public int getLoad() {
            return load;
        }

        public int getLength() {
            return length;
        }

        public int getValue() {
            return value;
        }

        public void setLoad(int load) {
            this.load = load;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void incrementLoad() {
            this.load += 1;
        }

        public int getId() {
            return id;
        }
    }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] features = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] length = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Node root = new Node(features[0], 0, 1);
            root.setParent(null);
            ArrayList<Node> nodeStorage = new ArrayList<Node>();
            nodeStorage.add(root);

            for (int i = 0; i < n - 1; i++) {
                nodeStorage.add(new Node(features[i + 1], length[i], i + 2));
            }

            for (int i = 1; i < n; i++) {
                nodeStorage.get(i).setParent(nodeStorage.get(numbers[i-1]-1));
            }


            for (int i = n - 1; i >0 ; i--) {
                Node node  = nodeStorage.get(i);
                Node parent = node.getParent();
                int totalLength = node.getLength();
                while (parent != null) {
                    if (totalLength <= node.getValue()) {
                        parent.incrementLoad();
                    }
                    totalLength += parent.getLength();
                    parent = parent.getParent();
                }
            }


            System.out.print(nodeStorage.get(0).getLoad());
            for (int i = 1; i < n; i++) {
                System.out.print(" " + nodeStorage.get(i).getLoad());
            }
    }
}
