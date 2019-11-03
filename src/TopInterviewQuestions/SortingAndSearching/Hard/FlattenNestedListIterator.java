package TopInterviewQuestions.SortingAndSearching.Hard;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {

    public interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();

    }

    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {

            for(int i = nestedList.size() - 1; i >= 0; i--)
                stack.push(nestedList.get(i));

        }

        public Integer next() {
            return stack.pop().getInteger();
        }

        public boolean hasNext() {

            while(!stack.isEmpty()) {

                NestedInteger current = stack.peek();
                if(current.isInteger())
                    return true;

                stack.pop();
                for(int i = current.getList().size() - 1; i >= 0; i--)
                    stack.push(current.getList().get(i));
            }
            return false;
        }
    }
}
