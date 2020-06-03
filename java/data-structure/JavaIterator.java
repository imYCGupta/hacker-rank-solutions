
         Object element = it.next();
         while(element instanceof Integer){
            it.remove();
            element = it.next();
         }
