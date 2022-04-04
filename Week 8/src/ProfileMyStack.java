import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jfree.data.xy.XYSeries;

import Profiler.Timeable;

public class ProfileMyStack {
        /**
         * @param args
         */
        public static void main(String[] args) {
            profileArrayListAddEnd();
            //profileArrayListAddBeginning();
            //profileLinkedListAddBeginning();
            //profileLinkedListAddEnd();
        }

        /**
         * Instead of filling them in, I will make a new method for each of them to use (helper method)
         * There's more I could do to make it better, but I didn't want to change it too much
         */
        public static void profileListAdd(boolean isArrayList, boolean isEnd){
            Timeable timeable = new Timeable() {
                List<String> list;
                public void setup(int n) {
                    // For some reason, when passing an arraylist into the method, the process slowed down
                    // dramatically (by half an exponent). So instead of that I just passed a boolean and created either
                    // an array or linked list here.
                    if (isArrayList) {
                        list = new ArrayList<>();
                    }
                    else {
                        list = new LinkedList<>();
                    }
                }

                public void timeMe(int n) {
                    for (int i = 0; i < n; i++) {
                        // Having this if statement outside the loop might speed it up but there would be duplicate code,
                        // and I ran it both ways and didn't notice a difference.
                        if (isEnd) {
                            list.add("a string");
                        } else {
                            list.add(0, "a string");
                        }
                    }
                }
            };
            int startN = 4000;
            int endMillis = 5000;
            String title = (isArrayList ? "ArrayList" : "LinkedList") + " add " + (isEnd ? "end" : "beginning");
            runProfiler(title, timeable, startN, endMillis);
        }

        /**
         * Characterize the run time of adding to the end of an ArrayList
         */
        public static void profileArrayListAddEnd() {
            profileListAdd(true, true);
        }

        /**
         * Characterize the run time of adding to the beginning of an ArrayList
         */
        public static void profileArrayListAddBeginning() {
            profileListAdd(true, false);
        }

        /**
         * Characterize the run time of adding to the beginning of a LinkedList
         */
        public static void profileLinkedListAddBeginning() {
            profileListAdd(false, false);
        }

        /**
         * Characterize the run time of adding to the end of a LinkedList
         */
        public static void profileLinkedListAddEnd() {
            profileListAdd(false, true);
        }

        /**
         * Runs the profiles and displays results.
         *
         * @param timeable
         * @param startN
         * @param endMillis
         */
        private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
            Profiler profiler = new Profiler(title, timeable);
            XYSeries series = profiler.timingLoop(startN, endMillis);
            profiler.plotResults(series);
        }
    }
}
