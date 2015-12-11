package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    private static final long serialVersionUID = 1L;
    int size = 0;
    Node<String> root;

    public Solution()
    {
        root = new Node<>(null);
    }

    public String getParent(String value)
    {
        Node<String> searchedParentChild;
        if (value == null)
        {
            return null;
        }
        Itr itr = (Itr) this.iterator();
        if (itr.hasNext())
        {
            itr.next();
        } else
        {
            return null;
        }
        while (itr.hasNext() && !itr.getLastReturned().item.equals(value))
        {
            itr.next();
        }

        searchedParentChild = itr.getLastReturned();
        if (searchedParentChild.parent == root)
        {
            return null;
        } else if (!searchedParentChild.item.equals(value))
        {
            return null;
        } else
        {
            return (String) searchedParentChild.parent.item;
        }
    }

    @Override
    public boolean add(String s)
    {
        Node<String> newNode = new Node<>(s);
        Node<String> newNodeParent;

        //get to last element
        Node<String> lastNode = root;
        while (lastNode.child1 != null || lastNode.child2 != null || lastNode.nextOnThisLevel != null)
        {
            if (lastNode.child1 != null)
                lastNode = lastNode.child1;
            else if (lastNode.child2 != null)
                lastNode = lastNode.child2;
            else
                lastNode = lastNode.nextOnThisLevel;
        }
        //choosing parent element
        //check if possible to add to last element parent
        if (lastNode.parent != null && lastNode == lastNode.parent.child1)
        {
            newNodeParent = lastNode.parent;
        }
        //or to next parent of prev level
        else if (lastNode.parent != null && lastNode.parent.nextOnThisLevel != null)
        {
            newNodeParent = lastNode.parent.nextOnThisLevel;
        }
        //or to next level
        else
        {
            newNodeParent = lastNode;
            while (newNodeParent.prevOnThisLevel != null)
            {
                newNodeParent = newNodeParent.prevOnThisLevel;
            }
        }
        // connecting newNode to parent
        newNode.parent = newNodeParent;
        //and parent to newNode
        if (newNodeParent.child1 == null)
        {
            newNodeParent.child1 = newNode;
        } else
        {
            newNodeParent.child2 = newNode;
        }
        //check if there is parent with children on prev level
        if (newNode == newNode.parent.child2)
        {
            newNode.prevOnThisLevel = newNode.parent.child1;
            newNode.parent.child1.nextOnThisLevel = newNode;
        } else if (newNode.parent.prevOnThisLevel != null)
        {
            Node<String> tempNode = newNode.parent.prevOnThisLevel;
            while (tempNode.prevOnThisLevel != null && tempNode.child1 == null && tempNode.child2 == null)
            {
                tempNode = tempNode.prevOnThisLevel;
            }
            if (tempNode.child2 != null)
            {
                tempNode.child2.nextOnThisLevel = newNode;
                newNode.prevOnThisLevel = tempNode.child2;
            } else if (tempNode.child1 != null)
            {
                tempNode.child1.nextOnThisLevel = newNode;
                newNode.prevOnThisLevel = tempNode.child1;
            }
        }
        size++;
        return true;
    }

    public boolean remove(String s)
    {
        //getting element for removal
        Node<String> nodeForRemoval;
/*        if (s == null)
        {
            System.out.println("null value");
            throw new IllegalArgumentException();
        }*/
        Itr itr = (Itr) this.iterator();
        if (itr.hasNext())
        {
            itr.next();
        } else
        {
            return false;
        }
        while (itr.hasNext() && !itr.getLastReturned().item.equals(s))
        {
            itr.next();
        }

        nodeForRemoval = itr.getLastReturned();

        if(s != null && nodeForRemoval.item != null && !nodeForRemoval.item.equals(s))
        {
            return false;
        }
        else if((s == null && nodeForRemoval.item != null) || (s != null && nodeForRemoval.item == null))
        {
            return false;
        }

        //removing remaining children
        if (nodeForRemoval.child2 != null)
        {
            remove(nodeForRemoval.child2.item);
        }
        if (nodeForRemoval.child1 != null)
        {
            remove(nodeForRemoval.child1.item);
        }


        //disconnecting from parent and moving second child if it exists
        if (nodeForRemoval == nodeForRemoval.parent.child1)
        {
            if (nodeForRemoval.parent.child2 == null)
            {
                nodeForRemoval.parent.child1 = null;
            } else
            {
                nodeForRemoval.parent.child1 = nodeForRemoval.parent.child2;
                nodeForRemoval.parent.child2 = null;
            }

        } else
        {
            nodeForRemoval.parent.child2 = null;
        }
        //disconnecting from previous on level
        if (nodeForRemoval.prevOnThisLevel != null)
        {
            if (nodeForRemoval.nextOnThisLevel != null)
            {
                nodeForRemoval.prevOnThisLevel.nextOnThisLevel = nodeForRemoval.nextOnThisLevel;
            } else
            {
                nodeForRemoval.prevOnThisLevel.nextOnThisLevel = null;
            }

        }
        //disconnecting from next on level
        if (nodeForRemoval.nextOnThisLevel != null)
        {
            if (nodeForRemoval.prevOnThisLevel != null)
            {
                nodeForRemoval.nextOnThisLevel.prevOnThisLevel = nodeForRemoval.prevOnThisLevel;
            } else
            {
                nodeForRemoval.nextOnThisLevel.prevOnThisLevel = null;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        if (o instanceof String || o == null)
        {
            return remove((String) o);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        root.child1 = null;
        root.child2 = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o)
    {
        if (o instanceof String || o == null)
        {
            String searchedString = (String) o;
            Itr itr = (Itr) this.iterator();
            if (itr.hasNext())
            {
                itr.next();
            } else
            {
                return false;
            }
            while (itr.hasNext() && !itr.getLastReturned().item.equals(searchedString))
            {
                itr.next();
            }
            if(itr.getLastReturned().item == null && searchedString == null)
            {
                return true;
            }
            else if (itr.getLastReturned().item.equals(searchedString))
            {
                return true;
            } else
            {
                return false;
            }
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Solution strings = (Solution) o;

        if (size != strings.size) return false;
        if (root != null ? !root.equals(strings.root) : strings.root != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + size;
        result = 31 * result + (root != null ? root.hashCode() : 0);
        return result;
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        Solution clonedSolution = new Solution();
        clonedSolution.size = this.size();
        Map<String, Node<String>> newNodesMap = new HashMap<>();

        Itr thisListItrForCopy = (Itr) this.iterator();

        if (!thisListItrForCopy.hasNext())
        {
            return clonedSolution;
        }
        thisListItrForCopy.next();
        while (true)
        {
            Node<String> newNode = new Node<>((String) thisListItrForCopy.getLastReturned().item);
            newNodesMap.put(newNode.item, newNode);
            if (thisListItrForCopy.hasNext())
            {
                thisListItrForCopy.next();

            } else
            {
                break;
            }
        }

        Itr thisListItrForConnecting = (Itr) this.iterator();

        while (true)
        {
            Node<String> thisListCurrentNode = thisListItrForConnecting.getLastReturned();
            Node<String> newNode;

            if (thisListCurrentNode == this.root)
            {
                newNode = clonedSolution.root;
            } else
            {
                newNode = newNodesMap.get(thisListCurrentNode.item);
            }

            if (thisListCurrentNode.parent != null && thisListCurrentNode.parent != this.root)
            {
                newNode.parent = newNodesMap.get(thisListCurrentNode.parent.item);
            } else if (thisListCurrentNode.parent != null && thisListCurrentNode.parent == this.root)
            {
                newNode.parent = clonedSolution.root;
            }

            if (thisListCurrentNode.child1 != null)
            {
                newNode.child1 = newNodesMap.get(thisListCurrentNode.child1.item);
            }
            if (thisListCurrentNode.child2 != null)
            {
                newNode.child2 = newNodesMap.get(thisListCurrentNode.child2.item);
            }
            if (thisListCurrentNode.prevOnThisLevel != null)
            {
                newNode.prevOnThisLevel = newNodesMap.get(thisListCurrentNode.prevOnThisLevel.item);
            }
            if (thisListCurrentNode.nextOnThisLevel != null)
            {
                newNode.nextOnThisLevel = newNodesMap.get(thisListCurrentNode.nextOnThisLevel.item);
            }

            if (thisListItrForConnecting.hasNext())
            {
                thisListItrForConnecting.next();

            } else
            {
                break;
            }
        }
        return clonedSolution;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Itr();
    }


    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }


    private static class Node<String> implements Serializable
    {
        private static final long serialVersionUID = 2L;
        String item;
        Node<String> child1;
        Node<String> child2;
        Node<String> nextOnThisLevel;
        Node<String> prevOnThisLevel;
        Node<String> parent;

        Node(String item)
        {
            this.item = item;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (item != null ? !item.equals(node.item) : node.item != null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            return item != null ? item.hashCode() : 0;
        }
    }

    private class Itr implements Iterator<String>
    {
        private Node<String> lastReturned = null;

        Itr()
        {
            lastReturned = root;
        }

        public Node getLastReturned()
        {
            return lastReturned;
        }

        @Override
        public boolean hasNext()
        {
            if (lastReturned.nextOnThisLevel != null)
            {
                return true;
            } else
            {
                Node<String> firstOnThisLevelWithChildren = lastReturned;
                while (firstOnThisLevelWithChildren.prevOnThisLevel != null)
                    firstOnThisLevelWithChildren = firstOnThisLevelWithChildren.prevOnThisLevel;
                while (firstOnThisLevelWithChildren.child1 == null && firstOnThisLevelWithChildren.child2 == null && firstOnThisLevelWithChildren.nextOnThisLevel != null)
                    firstOnThisLevelWithChildren = firstOnThisLevelWithChildren.nextOnThisLevel;
                if (firstOnThisLevelWithChildren.child1 != null)
                {
                    return true;
                } else if (firstOnThisLevelWithChildren.child2 != null)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
        }

        @Override
        public String next()
        {
            if (lastReturned.nextOnThisLevel != null)
            {
                lastReturned = lastReturned.nextOnThisLevel;
                return lastReturned.item;
            } else
            {
                Node<String> firstOnThisLevelWithChildren = lastReturned;
                while (firstOnThisLevelWithChildren.prevOnThisLevel != null)
                    firstOnThisLevelWithChildren = firstOnThisLevelWithChildren.prevOnThisLevel;
                while (firstOnThisLevelWithChildren.child1 == null && firstOnThisLevelWithChildren.child2 == null && firstOnThisLevelWithChildren.nextOnThisLevel != null)
                    firstOnThisLevelWithChildren = firstOnThisLevelWithChildren.nextOnThisLevel;
                if (firstOnThisLevelWithChildren.child1 != null)
                {
                    lastReturned = firstOnThisLevelWithChildren.child1;
                    return lastReturned.item;
                } else
                {
                    lastReturned = firstOnThisLevelWithChildren.child2;
                    return lastReturned.item;
                }
            }
        }


        @Override
        public void remove()
        {
            Solution.this.remove(lastReturned.item);
        }
    }

    //for testing
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
/*        List<String> list = new Solution();
        for (int i = 1; i < 16; i++)
        {
            list.add(String.valueOf(i));
        }
        ((Solution) list).print();
        list.clear();
        ((Solution) list).print();
        System.out.println("list.add(\"a\") " + list.add("a"));
        System.out.println("list.add(\"b\") " + list.add("b"));
        System.out.println("list.add(\"c\") " + list.add("c"));
        System.out.println("list.add(\"d\") " + list.add("d"));
        System.out.println("list.add(\"e\") " + list.add("e"));
        ((Solution) list).print();
        System.out.println("list.remove(null) " + list.remove(null));
        System.out.println("list.remove(null) " + list.remove(null));
        ((Solution) list).print();
        list.clear();
        System.out.println("list.remove(null) " + list.remove(null));
        System.out.println("list.remove(null) " + list.remove(null));
        ((Solution) list).print();*/

        List<String> list = new Solution();
        for (int i = 1; i < 16; i++)
        {
            list.add(String.valueOf(i));
        }


        /*((Solution) list).print();
        ((Solution) list).printDetails();
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        System.out.println("list.remove(\"9\") " + list.remove("9"));
        System.out.println("list.remove(\"51\") " + list.remove("51"));
        System.out.println("list.add(\"16\") " + list.add("16"));
        System.out.println("list.add(\"17\") " + list.add("17"));
        System.out.println("list.add(\"18\") " + list.add("18"));
        System.out.println("list.add(\"19\") " + list.add("19"));
        System.out.println("list.add(\"20\") " + list.add("20"));
        System.out.println("list.remove(\"18\") " + list.remove("18"));
        System.out.println("list.remove(\"20\") " + list.remove("20"));
        System.out.println("list.add(\"21\") " + list.add("21"));
        System.out.println("list.add(\"22\") " + list.add("22"));
        System.out.println("list.remove(\"22\") " + list.remove("22"));
        ((Solution) list).print();
        System.out.println("list.remove(\"22\") " + list.remove("22"));
        ((Solution) list).print();
        System.out.println("list.add(\"22\") " + list.add("22"));
        ((Solution) list).print();
        System.out.println("list.add(\"23\") " + list.add("23"));
        ((Solution) list).print();
        System.out.println("list.clear()");
        list.clear();
        ((Solution) list).print();*/
        /*System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        ((Solution) list).print();
        System.out.println("list.remove(null) " + list.remove(null));
        System.out.println("list.remove(null) " + list.remove(null));
        ((Solution) list).print();*/
        /*System.out.println("list.add(\"a\") " + list.add("a"));
        System.out.println("list.add(\"b\") " + list.add("b"));
        System.out.println("list.add(\"c\") " + list.add("c"));
        System.out.println("list.add(\"d\") " + list.add("d"));
        System.out.println("list.add(\"e\") " + list.add("e"));
        ((Solution) list).print();
        System.out.println("list.remove(\"a\") " + list.remove("a"));
        System.out.println("list.remove(\"b\") " + list.remove("b"));
        ((Solution) list).print();
        for (int i = 1; i < 16; i++)
        {
            System.out.println("list.add(\"" + i + "\") " + list.add(String.valueOf(i)));
        }
        ((Solution) list).print();
        System.out.println("Parent 3 <- 1 = " + ((Solution) list).getParent("3"));
        System.out.println("Parent 5 <- 2 = " + ((Solution) list).getParent("5"));
        System.out.println("Parent 7 <- 3 = " + ((Solution) list).getParent("7"));
        System.out.println("Parent 10 <- 4 = " + ((Solution) list).getParent("10"));
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        ((Solution) list).print();
        System.out.println("Parent null <- 11 = " + ((Solution) list).getParent("11"));
        System.out.println("Parent null <- null = " + ((Solution) list).getParent(null));*/
        System.out.println("list.add(null) " + list.add(null));
        //System.out.println("Size = 9 = " + list.size());
        System.out.println(list.contains(null));
        list.remove(null);
        System.out.println(list.contains(null));

/*        System.out.print("\nSave list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" done\n");
        ((Solution) list2).print();
        System.out.println("list.iterator()");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();*/
        /*
        iterator = list.iterator();
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.remove() ");
        iterator.remove();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        ((Solution) list).print();
        iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println("\nlist.listIterator() while .hasNext() .next()");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) System.out.print(listIterator.next() + " ");
        System.out.println("\nwhile .hasPrevious() .previous()");
        while (listIterator.hasPrevious()) System.out.print(listIterator.previous() + " ");
        System.out.println("\nlistIterator.set(\"0\")");
        listIterator.set("0");
        ((Solution) list).print();
        System.out.println("listIterator.add(\"16\")");
        listIterator.add("16");
        ((Solution) list).print();
        System.out.println("listIterator.next() " + listIterator.next());
        System.out.println("listIterator.remove()");
        listIterator.remove();
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        System.out.println("listIterator.previous() " + listIterator.previous());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        ((Solution) list).print();
        listIterator = list.listIterator(1);
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.next() " + listIterator.next());*/
    }

    public void print()
    {
        System.out.println("=============PRINT=============");
        if (root.child1 != null) print(root.child1, "");
        if (root.child2 != null) print(root.child2, "");
        System.out.println();
        System.out.println("===============================");
    }

    private void print(Node node, String s)
    {
        if (node.equals(node.parent.child2))
        {
            System.out.println();
            System.out.print(s);
        }
        System.out.print("->" + node.item);
        if (node.child1 != null) print(node.child1, s + "|||");
        if (node.child2 != null) print(node.child2, s + "|||");
    }

    private void printDetails()
    {
        Iterator<String> iterator = iterator();
        while (iterator.hasNext())
        {
            iterator.next();
            Node<String> node = ((Itr) iterator).getLastReturned();
            System.out.print("Node: " + node.item);
            System.out.print(" | ");
            System.out.print("Parent: ");
            if (node.parent == root)
            {
                System.out.print("root");
            } else
            {
                System.out.print(node.parent.item != null ? node.parent.item : null);
            }

            System.out.print(" | ");
            System.out.print("Previous on level: ");
            System.out.print(node.prevOnThisLevel != null ? node.prevOnThisLevel.item : null);
            System.out.print(" | ");
            System.out.print("Next on level: ");
            System.out.print(node.nextOnThisLevel != null ? node.nextOnThisLevel.item : null);
            System.out.println(" | ");
        }
    }
    /////////////////////////////////
}
