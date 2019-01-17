package tplabs;

import java.io.*;
import java.util.ArrayList;

public class MultiLevelDock {
    ArrayList<Dock<Transport>> dockStages;

    private final int countPlaces = 20;
    private int pictureWidth;
    private int pictureHeight;

    public MultiLevelDock(int countStages, int pictureWidth, int pictureHeight) {
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
        dockStages = new ArrayList<Dock<Transport>>();
        for (int i = 0; i < countStages; i++) {
            dockStages.add(new Dock<Transport>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Dock<Transport> getDock(int ind) {
        if ((ind > -1) && (ind < dockStages.size())) {
            return dockStages.get(ind);
        }
        return null;
    }

    public boolean saveData(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            writeToFile("CountLeveles:" + dockStages.size() + System.lineSeparator(), bw);
            for (var level : dockStages) {
                writeToFile("Level" + System.lineSeparator(), bw);
                for (int i = 0; i < countPlaces; i++) {
                    Transport ship = level.getTrasport(i);
                    if (ship != null) {
                        if (ship.getClass().getSimpleName().equals("BasicShip")) {
                            writeToFile(i + ":BasicShip:", bw);
                        }
                        if (ship.getClass().getSimpleName().equals("Ship")) {
                            writeToFile(i + ":Ship:", bw);
                        }
                        writeToFile(ship + System.lineSeparator(), bw);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean loadData(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }
        String bufferTextFromFile = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                bufferTextFromFile += line + "\n";
            }
            var strs = bufferTextFromFile.split("\n");
            if (strs[0].contains("CountLeveles")) {
                //считываем количество уровней
                int count = Integer.parseInt(strs[0].split(":")[1]);
                if (dockStages != null) {
                    dockStages.clear();
                }
                dockStages = new ArrayList<Dock<Transport>>(count);
            } else {
                //если нет такой записи, то это не те данные
                return false;
            }
            int counter = -1;
            Transport ship = null;
            for (int i = 1; i < strs.length - 1; ++i) {
                //идем по считанным записям
                if (strs[i].equals("Level")) {
                    //начинаем новый уровень
                    counter++;
                    dockStages.add(new Dock<Transport>(countPlaces, pictureWidth, pictureHeight));
                    continue;
                }
                if (strs[i].isEmpty() || strs[i] == null) {
                    continue;
                }
                if (strs[i].split(":")[1].equals("BasicShip")) {
                    ship = new BasicShip(strs[i].split(":")[2]);
                } else if (strs[i].split(":")[1].equals("Ship")) {
                    ship = new Ship(strs[i].split(":")[2]);
                }
                dockStages.get(counter).setTrasport(Integer.parseInt(strs[i].split(":")[0]), ship);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private void writeToFile(String text, BufferedWriter writer) {
        try {
            char[] info = text.toCharArray();
            writer.write(info, 0, info.length);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
