/*
 *   This file is part of the computer assignment for the
 *   Information Retrieval course at KTH.
 *
 *   Johan Boye, 2017
 */

package ir;

import java.util.ArrayList;

public class PostingsList {

    /** The postings list */
    private ArrayList<PostingsEntry> list = new ArrayList<PostingsEntry>();


    /** Number of postings in this list. */
    public int size() {
        return list.size();
    }

    /** Returns the ith posting. */
    public PostingsEntry get( int i ) {
        return list.get( i );
    }

    //
    //  YOUR CODE HERE
    //
    public void add( PostingsEntry newEntry ) {
        //We don't want duplicates nor randomized order.
        for ( int i = 0; i < size(); i++ ) {
            PostingsEntry existingEntry = list.get( i );

            if ( newEntry.docID == existingEntry.docID ) {
                //Don't add duplicates
                return;
            }
            else if ( newEntry.docID < existingEntry.docID ) {
                //If docID is lower, insert and shift others right.
                list.add( i, existingEntry );
                return;
            }
        }
        //Add to end.
        list.add( newEntry );
    }
}
