import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {
    Flower() {
    }

    public String whatsYourName() {
        return "I have many names and types";
    }
}

class Jasmine extends Flower {
    @Override
    public String whatsYourName() {
        // TODO Auto-generated method stub
        return "Jasmine";
    }
}

class Lotus extends Flower {
    @Override
    public String whatsYourName() {
        // TODO Auto-generated method stub
        return "Lotus";
    }
}

class Lily extends Flower {
    @Override
    public String whatsYourName() {
        // TODO Auto-generated method stub
        return "Lily";
    }
}

class Region {
    Region() {
    }

    Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal extends Region {
    @Override
    Jasmine yourNationalFlower() {
        // TODO Auto-generated method stub
        return new Jasmine();
    }
}

class AndhraPradesh extends Region {
    @Override
    Lily yourNationalFlower() {
        // TODO Auto-generated method stub
        return new Lily();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}