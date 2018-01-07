/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author jan
 */
public class Storage extends Node {
    	public Storage(String comment) {
		super(null);
	}

	@Override
	public String toString() {
		return comment;
	}    
}
