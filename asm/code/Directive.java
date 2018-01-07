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
public class Directive extends Node {
    	public Directive(mnemonics.Mnemonic mD, int value) {
		super(null);
	}

	@Override
	public String toString() {
		return comment;
	}
}
