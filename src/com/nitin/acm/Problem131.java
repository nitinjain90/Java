package com.nitin.acm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by harash on 04/06/16.
 */
//Psychic poker player
public class Problem131 {



    public List<String> parseInput(String line) {
        return null;
    }



    public String bestHandValue(List<String> hand, List<String> deck) {
        for (int discard = 0; discard < 5; discard++) {
            List<String> finalHand = new ArrayList<>();


        }
    }

    public String bestHandValue2(List<String> )

    // ["AH", "TH", ...] => "four-of-a-kind"
    public String handValue(String[] hand) {

    }

    // "four-of-a-kind" , "two-pairs" => 1
    public int compare(String value1, String value2) {

    }
    // ["AH", "QH, "TD"], 2 => [ ["AH", "QH" ], [ "QH", "TD" ], [ "AH", "TD" ] ]
    // "AH" => (["QH", "TD"], 1) = [["QH"], ["TD"]]
    public Set<Set<String>> combinations(List<String> hand, int N) {
        if (N == 0) {
            return new TreeSet<>();
        }

        Set<Set<String>> output = new TreeSet<>();

        for (int i = 0; i < hand.size(); i++) {
            String out = hand.get(i);
            List<String> temp = new ArrayList<>(hand);
            temp.remove(i);

            Set<Set<String>> answers = combinations(temp, N - 1);

            for (Set<String> answer : answers) {
                Set<String> temp2 = new TreeSet<>(answer);
                temp2.add(out);

                output.add(temp2);
            }

        }

        return output;
    }
}
