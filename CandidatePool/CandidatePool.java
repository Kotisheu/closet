//Sean Fitzgerald, Nick Romanoff, Sherry Ko
//The Computers
//pd09
//HW42
//2013-12-12

/*=====================================
  class CandidatePool -- 


  Each CandidatePool object contains the following
  instance variables that you may need to use:
  pool
  An ArrayList of only Candidate objects


  You will need to write the following methods:
  getCandidatesForPosition( String pos )
  Returns a candidate-only ArrayList containing all
  the Candidates in pool that have position pos.

  getBestCandidate( String pos )
  Returns the Candidte in pool that matches position
  pos with the highest score.
  If there are no candidates for the given position,
  returns null.

  removeCandidatesForPosition( String pos )
  Removes all the Candidates in the pool that match
  position pos.
  Returns number of candidates removed.
  =====================================*/

//We usually leave this out because Java does this automatically:
import java.io.*;
//...but this is not automatically performed (util pkg contains ArrayList):
import java.util.*;


public class CandidatePool {
    
    //=================================
    //DO NOT MODIFY THIS CODE BLOCK
    ArrayList<Candidate> pool;
    
    public CandidatePool() {
        pool = new ArrayList<Candidate>();
    }

    public void addCandidate( Candidate c ) {
        pool.add(c);
    }

    public String toString() {
        return pool.toString();
    }
    //=================================



    //YOUR WORK BELOW:
    public ArrayList<Candidate> getCandidatesForPosition( String pos ) {
        ArrayList<Candidate> temp = new ArrayList<Candidate>();
        for (int i = 0; i < pool.size(); i++) {
            if ( pool.get(i).getPosition().equals(pos) )
                temp.add(pool.get(i));
        }
        return temp;
    }


    public Candidate getBestCandidate( String pos ) {
        ArrayList<Candidate> temp = getCandidatesForPosition( pos );
        Candidate joe = new Candidate(0, pos, 0);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getInterviewScore() > joe.getInterviewScore())
                joe = temp.get(i);
        }
        return joe;
    }


    public int removeCandidatesForPosition( String pos ) {
        int retInt = 0;
	for (int i = 0; i < pool.size(); i++) {
	    if ( pool.get(i).getPosition().equals(pos) ) {
		pool.remove(i);
		i--;
		retInt++;
	    }
	}
	return retInt;
    }


}//end class CandidatePool
