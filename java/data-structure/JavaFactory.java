
            if(order!=null && order.equals("cake")){
                return new Cake();
            }else if(order!=null && order.equals("pizza")){
                return new Pizza();
            }else{
                return null;
            }

