public class BinaryTreeNode {
	BinaryTreeNode left, right;
	int data;
	
	public BinaryTreeNode(int data) {
		 this.data = data;
	}
	
	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new BinaryTreeNode(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new BinaryTreeNode(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if (value == data) {
			return true;
		} else if (value < data) {
			if (left != null) {
				left.contains(value);
			} else {
				return false;
			}
		} else {
			if (right != null) {
				right.contains(value);
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 			10
	 * 		   /  \
	 * 		  5	   15
	 *         \
	 *         	8	
	 *  Output will be 5, 8, 10, 15
	 */
	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if (right != null) {
			right.printInOrder();
		}
	}
	
	/**
	 * 			10
	 * 		   /  \
	 * 		  5	   15
	 *         \
	 *         	8	
	 *  Output will be 10, 5, 8, 15
	 */
	public void printPreOrder() {
		System.out.println(data);
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}
	
	/**
	 * 			10
	 * 		   /  \
	 * 		  5	   15
	 *         \
	 *         	8	
	 *  Output will be 8, 5, 15, 10
	 */
	public void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.println(data);
	}
	
}	
