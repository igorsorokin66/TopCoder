import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//3 hours

public class SmartWordToy
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(new FileReader("src/input.txt"));
		
		while (inputFile.hasNext())
		{
			String start = inputFile.nextLine().replaceAll("\"", "");
			String finish = inputFile.nextLine().replaceAll("\"", "");
			String[] forbid = inputFile.nextLine().replaceAll("[\"{}]", "").split(",");//removes " {} and spaces
			System.out.println("Result: " + minPresses(start, finish, forbid));
			System.out.println("Expected: " + inputFile.nextLine().split(":")[1]);
			inputFile.nextLine();
			found = false;
			gene = new int[10];
			count = new int[10];
		}
		inputFile.close();
	}
	
	public static class Node
	{
        private String data;
        private Node parent;
        private List children;
        
        Node(String data, Node parent, List children)
        {
        	this.data = data;
        	this.parent = parent;
        	this.children = children;
        }
    }
	
	static Node root;
	static int minPresses(String start, String finish, String[] forbid)
	{
		root = new Node(start, null, new LinkedList<Node>());
		getChildren(start, finish, root, root, forbid, 0);
		for (int i = 0; i < gene.length; i++)
		{
			if (gene[i] == 0) return i;
		}
		return 0;
	}
	
	static boolean search(String data, Node from)
	{
		//if (data.equals("aacb"))
		//	System.out.println();
		if (from.children != null)
			for (Object c : from.children)
			{
				Node check = (Node) c;
				if (check.data.equals(data)) 
					return true;
				else 
					if (search(data, check)) return true;
			}
		return false;
	}
	
	static boolean forbidContains(String data, String[] forbid)
	{
		for (int i = 0; i < forbid.length; i++)
		{
			if (forbid[0].contains(String.valueOf(data.charAt(i)))) return false;
		}
		return true;
	}

	static boolean found = false;
	static int[] gene = new int[10];
	static int[] count = new int[10];
	static void getChildren(String start, String finish, Node current, Node parent, String[] forbid, int level)
	{
		if (current.children.size() == 0)
		{
		for (int i = 0; i < start.length(); i++)
		{
			char forward;
			char backward;
			if ((int)start.charAt(i)+1 > 122) forward = (char)((int)start.charAt(i)-25);
			else forward = (char)((int)start.charAt(i)+1);
			
			if ((int)start.charAt(i)-1 < 97) backward = (char)((int)start.charAt(i)+25);
			else backward = (char)((int)start.charAt(i)-1);
			
			String forwardChild = start.substring(0,i) + (String.valueOf(forward)) + start.substring(i+1, start.length());
			if (forwardChild.equals(finish)) found = true;
			if (forbidContains(forwardChild, forbid) && !forwardChild.equals(parent.data) && !search(forwardChild, root) && (parent.parent == null || !forwardChild.equals(parent.parent.data))) 
			{
				Node child = new Node(forwardChild, parent, new LinkedList<Node>()); //System.out.println(forwardChild);
				current.children.add(child);
			}
			if (!forbid[0].equals(""))
			{
			String backwardChild = start.substring(0,i) + (String.valueOf(backward)) + start.substring(i+1, start.length());
			if (backwardChild.equals(finish)) found = true;
			if (forbidContains(backwardChild, forbid) && !backwardChild.equals(parent.data) && !search(backwardChild, root) && (parent.parent == null || !backwardChild.equals(parent.parent.data))) 
			{
				Node child = new Node(backwardChild, parent, new LinkedList<Node>()); //System.out.println(backwardChild);
				current.children.add(child);
			}
			}
		}
		gene[level] += current.children.size();
		count[level]++;
		}
		int i = 0;//abaa gives birth to abbb
		while ((current.equals(root) || gene[level-1+i] == count[level+i]) && !found)
		{
			if (!current.children.contains(finish))
			{
						for (int k = 0; k < level; k++) System.out.print("\t");
						System.out.print(current.data + ": ");
						for (Object n : current.children) System.out.print(((Node)n).data + ", ");
						System.out.println();
					for (int n = 0; n < current.children.size() && !found; n++)
					{
						Node child = (Node) current.children.get(n);
						if (!child.data.equals(finish)) getChildren(child.data, finish, child, current, forbid, level+1);
					}//^ current or child?
					i++;
			}
		}
		//if (i == 0) count[level]++;
	}
}
