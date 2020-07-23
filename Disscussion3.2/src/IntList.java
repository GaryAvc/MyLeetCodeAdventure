public class IntList {
 public int first;
 public IntList rest;
 public IntList (int f, IntList r) {
         this.first = f;
         this.rest = r;
         }

         /**
 10 * Given a sorted linked list of items - remove duplicates.
 11 * For example given 1 -> 2 -> 2 -> 2 -> 3,
 12 * Mutate it to become 1 -> 2 -> 3 (destructively)
 13 */
         public static void removeDuplicates(IntList p) {
         if (p == null) {
            return;
             }
          IntList current = p.rest;
         IntList previous = p;
         while (current != null) {
             if (current.first == previous.first) {
                 previous.rest = current.rest;
                 } else {
                 previous = current;
                 }
             current = previous.rest;
             }
          }
 }