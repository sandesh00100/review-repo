/**
 * Allows 1 or 2 keys per node
 *  2-node: one keys, two children
 *  3-node: two keys, three children
 *      left child has value lower than two keys, middle child has a node between the two keys  and right node has a value larger than two keys
 *
 *
 *                  M
 *                /  \
 *              EJ     R
 *            / | \   / \
 *          AC  H  L P   SX
 *         /|\ /\ /\/\  / | \ (Null links)
 * Every path from the root to null link has the same length (perfect balance)
 */

enum Color {
    RED,
    BLACK
}

