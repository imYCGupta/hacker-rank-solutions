

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        if(head == null){
            return false;
        }
        List<SinglyLinkedListNode> listOfTravesedNodes = new ArrayList<>();
        listOfTravesedNodes.add(head);
        while(head.next!=null){
            if(listOfTravesedNodes.contains(head.next)){
                return true;
            }
            listOfTravesedNodes.add(head.next);
            head = head.next;
        }
        return false;
    }

