

class Add{
    public void add(int ...a){
        if(a.length > 1){
            int sum = 0;
            String str = "";
            for(int i=0;i<a.length;i++){
                sum = sum + a[i];
                str = str + a[i]+"+";
            }
            System.out.println(str.substring(0,str.length()-1)+"="+sum);
        }
    }
}

