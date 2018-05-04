/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPE;

public class Node implements Comparable<Node>{

    private LibrosGenero info;
    private Node next;

    public Node() {
        info = null;
        next = null;
    }

    public Node(LibrosGenero l, Node n) {
        setInfo(l);
        setNext(n);
    }

    public void setInfo(LibrosGenero l) {
        info = l;
    }

    public void setNext(Node n) {
        next = n;
    }

    public LibrosGenero getInfo() {
        return info;
    }

    public Node getNext() {
        return next;
    }
    
    
    
    @Override
    public int compareTo (Node N) {
    	int res = this.getInfo().compareTo(N.getInfo());
    	return res;
    		   
    }



}