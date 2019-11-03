package Learn.QueueAndStack.Stack.DFS.Templates;

/**
 *
 * boolean DFS(RandomNode cur, RandomNode target, Set<RandomNode> visited) {
 *     return true if cur is target;
 *     for (next : each neighbor of cur) {
 *         if (next is not in visited) {
 *             add next to visted;
 *             return true if DFS(next, target, visited) == true;
 *         }
 *     }
 *     return false;
 * }
 */
