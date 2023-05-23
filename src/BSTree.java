import java.util.Stack;

public class BSTree<E extends Comparable<E>> {
	class Node {
		protected E data; 
		protected Node left, right;
		
		public Node(E data) {
			this(data, null, null);
		}
		
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right; 
		}
	}
	
	private Node root;
	
	public BSTree() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void insert(E x) throws ItemDuplicated {
		this.root = insertRecursive(this.root, x);
	}
	
	private Node insertRecursive(Node node, E x) throws ItemDuplicated {
		if (node == null) {
			return new Node(x);
		}
		
		int compareResult = x.compareTo(node.data);
		if (compareResult < 0) {
			node.left = insertRecursive(node.left, x);
		} else if (compareResult > 0) {
			node.right = insertRecursive(node.right, x);
		} else {
			throw new ItemDuplicated("Element already exists in the BST.");
		}
		
		return node;
	}
	
	public void remove(E x) throws ItemNoFound {
		this.root = removeRecursive(this.root, x);
	}
	
	private Node removeRecursive(Node node, E x) throws ItemNoFound {
		if (node == null) {
			throw new ItemNoFound("Element not found in the BST.");
		}
		
		int compareResult = x.compareTo(node.data);
		if (compareResult < 0) {
			node.left = removeRecursive(node.left, x);
		} else if (compareResult > 0) {
			node.right = removeRecursive(node.right, x);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				node.data = findMin(node.right);
				node.right = removeRecursive(node.right, node.data);
			}
		}
		
		return node;
	}
	
	private E findMin(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toStringRecursive(this.root, sb);
		return sb.toString();
	}
	
	private void toStringRecursive(Node node, StringBuilder sb) {
		if (node == null) {
			return;
		}
		
		toStringRecursive(node.left, sb);
		sb.append(node.data).append(" ");
		toStringRecursive(node.right, sb);
	}
	
	public void inOrder() {
		inOrderRecursive(this.root);
	}
	
	private void inOrderRecursive(Node node) {
		if (node == null) {
			return;
		}
		
		inOrderRecursive(node.left);
		System.out.print(node.data + " ");
		inOrderRecursive(node.right);
	}

    public int countNonLeafNodes() {
        return countNonLeafNodesRecursive(root);
    }

    private int countNonLeafNodesRecursive(Node node) {
        if (node == null || isLeafNode(node)) {
            return 0;
        }

        return 1 + countNonLeafNodesRecursive(node.left) + countNonLeafNodesRecursive(node.right);
    }

    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }	
    
    public int getHeight(E x) {
        Node node = findNode(root, x);
        if (node != null) {
            return getHeightRecursive(node);
        }
        return -1;
    }

    private Node findNode(Node node, E x) {
        if (node == null || x.equals(node.data)) {
            return node;
        }

        int compareResult = x.compareTo(node.data);
        if (compareResult < 0) {
            return findNode(node.left, x);
        } else {
            return findNode(node.right, x);
        }
    }

    private int getHeightRecursive(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeightRecursive(node.left);
        int rightHeight = getHeightRecursive(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public void preOrderIterative() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    
    public int calculateArea() {
        int leafNodes = countLeafNodes(root);
        int height = getHeightRecursive(root);
        return leafNodes * height;
    }

    private int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
    public Node findMinNode() {
        if (isEmpty()) {
            return null; // El árbol está vacío
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
    public Node findMaxNode() {
        if (isEmpty()) {
            return null; // El árbol está vacío
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }
    public void parenthesize() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.data);

            if (current.right != null) {
                stack.push(current.right);
                System.out.print("\t");
            }

            if (current.left != null) {
                stack.push(current.left);
                System.out.print("\t");
            }
        }
    }
}

