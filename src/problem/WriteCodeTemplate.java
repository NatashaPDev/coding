package problem;

import mooc.EdxIO;

import java.util.HashMap;
import java.util.Map;

public class WriteCodeTemplate {

    private static Map<Character, Integer> horizontalKeyboardIndices = new HashMap<>();
    private static Map<Character, Integer> verticalKeyboardIndices = new HashMap<>();

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            int w = io.nextInt();
            int h = io.nextInt();

            for (int i = h; i > 0; i--) {
                for (int j = 1; j < w + 1; j++) {

                    char key = io.nextChar();

                    horizontalKeyboardIndices.put(key, i);
                    verticalKeyboardIndices.put(key, j);
                }
            }

            Template template1 = fillTemplate(io);
            Template template2 = fillTemplate(io);
            Template template3 = fillTemplate(io);

            int min = Integer.MAX_VALUE;
            String minName = "";

            int distance1 = getDistance(template1);

            if (distance1 < min) {
                min = distance1;
                minName = template1.getName();
            }

            int distance2 = getDistance(template2);

            if (distance2 < min) {
                min = distance2;
                minName = template2.getName();
            }

            int distance3 = getDistance(template3);

            if (distance3 < min) {
                min = distance3;
                minName = template3.getName();
            }

            io.println(minName);
            io.print(min);
        }
    }

    private static int getDistance(Template template) {

        char[] symbols = template.getTemplate().toCharArray();

        int distance = 0;

        int previousHeight = 0;
        int previousWidth = 0;

        for (char symbol : symbols) {

            int h = horizontalKeyboardIndices.get(symbol);
            int w = verticalKeyboardIndices.get(symbol);

            if (previousHeight != 0) {
                distance += Math.max(Math.abs(h - previousHeight), Math.abs(w - previousWidth));
            }

            previousHeight = h;
            previousWidth = w;
        }

        return distance;
    }

    private static Template fillTemplate(EdxIO io) {

        StringBuilder template = new StringBuilder();

        String templateName = io.next();

        io.next();

        String line;

        while (!(line = io.next()).equals("%TEMPLATE-END%")) {
            template.append(line);
        }

        return new Template(templateName, template.toString());
    }

    private static class Template {

        private String name;

        private String template;

        public Template(String name, String template) {
            this.name = name;
            this.template = template;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }
    }
}


