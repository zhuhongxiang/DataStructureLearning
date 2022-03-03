package collections;

public class ChainedTable {
    private ChainedHashNode[] table;
    public ChainedTable(int tableSize){
        if (tableSize <= 0){
            throw new IllegalArgumentException("tableSize must be positive");
        }
        table = new ChainedHashNode[tableSize];
    }

    public Object put(Object key, Object element){
        ChainedHashNode cursor = null;
        Object answer = null;

        if (cursor == null){
            int i = hash(key);
            cursor = new ChainedHashNode();
            cursor.element = element;
            cursor.key = key;
            cursor.link = table[i];
            table[i] = cursor;
        }else {
            answer = cursor.element;
            cursor.element = element;
        }
        return answer;
    }
    private int hash(Object key){
        return Math.abs(key.hashCode())% table.length;
    }
    public Object get(Object key)
    {
        Object answer = null;
        for (int i = 0; i<table.length;i++){
            ChainedHashNode cursor = table[i];
            if (key == cursor.key){
                answer = cursor.element;
                break;
            }
        }
        return answer;
    }


    class ChainedHashNode{
        Object element;
        Object key;
        ChainedHashNode link;
    }
}
