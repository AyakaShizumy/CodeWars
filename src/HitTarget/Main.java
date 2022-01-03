package HitTarget;

public class Main {

    public static void main(String args[]) {
        String[] list = new String[]{
                "----",
                "----",
                "---x",
                "-^--"
        };
        String[] list1 = new String[]{
                "----",
                "----",
                "->-x",
                "----"
        };
        String[] list2 = new String[]{
                "----",
                "---^",
                "---x",
                "----"
        };
        String[] list3 = new String[]{
                "----",
                "<x--",
                "----",
                "----"
        };
        String[] list4 = new String[]{
                "----",
                "----",
                "----",
                "----"
        };
        System.out.println(canHit(list));
        System.out.println(canHit(list1));
        System.out.println(canHit(list2));
        System.out.println(canHit(list3));
        System.out.println(canHit(list4));
    }

    public static boolean canHit(String[] list){
        if(list.length == 0) return false;
        char bullet = '-';
        int bullet_x = -1, bullet_y = -1, target_x = -1, target_y = -1;
        int y = 0;
        for (String line : list) {
            int x = 0;
            for (char symbol : line.toCharArray()) {
                if(symbol == 'x'){
                    target_x = x; target_y = y;
                }else if(symbol != '-'){
                    bullet_x = x; bullet_y = y; bullet = symbol;
                }
                x++;
            }
            y++;
        }
        if(bullet == '-' || target_x == -1 || target_y == -1) return false;
        switch (bullet){
            case '>':
                return target_x > bullet_x && target_y == bullet_y;
            case '<':
                return target_x < bullet_x && target_y == bullet_y;
            case '^':
                return target_y < bullet_y && target_x == bullet_x;
            case 'v':
                return target_y > bullet_y && target_x == bullet_x;
            default:
                return false;
        }
    }
}