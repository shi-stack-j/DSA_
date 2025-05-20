public class String_Builder {
    public static void main(String[]args){
        //Here we will use StringBuilder class in place of string
        //The Deletion ,Insertion,Appending,Replacing can be performed in less TimeComplexity as compare to strings
        StringBuilder sb=new StringBuilder("Sh");
        //Inserting Character in string builder
        sb.insert(2,'i');
        sb.insert(3,'v');
        sb.insert(4,'a');
        sb.insert(5,'m');
        //We can insert string also
        sb.insert(6," Gangwar");
        System.out.println(sb);
        //Deleting from the string
        sb.delete(2,5);//->This will delete string from index- 2 to 4
        sb.deleteCharAt(1);//This will delete the char at index 1
        System.out.println(sb);
        //Fetching from the string
        char[] arr=new char[3];
        //This we fetch the char from index 3 - 5 and will store them in array arr from index 0
        sb.getChars(3,6,arr,0);
        //Will return the charAt(index)
        System.out.println(sb.charAt(1));
        System.out.println(arr);
        //Will fetch substring from index 3 - 5
        System.out.println(sb.substring(3,6));
        //Will fetch substring from 1 to lastIndex
        System.out.println(sb.substring(1));

    }
}
/*
In Java, StringBuilder is a class used to create and manipulate mutable strings.
Unlike String, which is immutable,
a StringBuilder allows you to modify the content of a string without creating new objects,
making it more efficient when performing operations
that require frequent modifications to strings (like appending, inserting, or deleting characters).
 */