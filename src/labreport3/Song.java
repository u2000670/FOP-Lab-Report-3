package labviva3q2;

import java.util.Scanner;

public class Song {

    private String[] title, singer, filename;
    private double[] duration;
    private int[] year;

    public Song(String[] title, String[] singer, String[] filename, double[] duration, int[] year) {
        this.title = title;
        this.singer = singer;
        this.filename = filename;
        this.duration = duration;
        this.year = year;
    }

    public void play(int i) {
        System.out.println(toString(i));
    }

    public int next(int i, int size) {
        if (i > size - 1) {
            i = 0;
        }
        play(i);
        return i;
    }

    public int previous(int i, int size) {
        if (i < 0) {
            i = size - 1;
        }
        play(i);
        return i;
    }

    public String sortTitle(int ascdsc, int size) {
        String tempTitle = "";
        String tempSinger = "";
        String tempFilename = "";
        int tempYear = 0;
        double tempDuration = 0;
        if (ascdsc == 1) {
            //ascending order
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int compare = title[i].compareToIgnoreCase(title[j]);
                    if (compare > 0) {
                        tempDuration = duration[i];
                        tempTitle = title[i];
                        tempSinger = singer[i];
                        tempFilename = filename[i];
                        tempYear = year[i];

                        duration[i] = duration[j];
                        title[i] = title[j];
                        singer[i] = singer[j];
                        filename[i] = filename[j];
                        year[i] = year[j];

                        duration[j] = tempDuration;
                        title[j] = tempTitle;
                        singer[j] = tempSinger;
                        filename[j] = tempFilename;
                        year[j] = tempYear;
                    }
                }
            }
            return "ASCENDING";
        }
        if (ascdsc == 2) {
            //ascending order
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int compare = title[i].compareToIgnoreCase(title[j]);
                    if (compare < 0) {
                        tempDuration = duration[i];
                        tempTitle = title[i];
                        tempSinger = singer[i];
                        tempFilename = filename[i];
                        tempYear = year[i];

                        duration[i] = duration[j];
                        title[i] = title[j];
                        singer[i] = singer[j];
                        filename[i] = filename[j];
                        year[i] = year[j];

                        duration[j] = tempDuration;
                        title[j] = tempTitle;
                        singer[j] = tempSinger;
                        filename[j] = tempFilename;
                        year[j] = tempYear;
                    }
                }
            }
            return "DESCENDING";
        }
        return "";
    }

    public String sortDuration(int ascdsc, int size) {
        String tempTitle = "";
        String tempSinger = "";
        String tempFilename = "";
        int tempYear = 0;
        double tempDuration = 0;
        if (ascdsc == 1) {
            //ascending order
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (duration[i] > duration[j]) {
                        tempDuration = duration[i];
                        tempTitle = title[i];
                        tempSinger = singer[i];
                        tempFilename = filename[i];
                        tempYear = year[i];

                        duration[i] = duration[j];
                        title[i] = title[j];
                        singer[i] = singer[j];
                        filename[i] = filename[j];
                        year[i] = year[j];

                        duration[j] = tempDuration;
                        title[j] = tempTitle;
                        singer[j] = tempSinger;
                        filename[j] = tempFilename;
                        year[j] = tempYear;
                    }
                }
            }
            return "ASCENDING";
        }
        if (ascdsc == 2) {
            //descending order
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (duration[i] < duration[j]) {
                        tempDuration = duration[i];
                        tempTitle = title[i];
                        tempSinger = singer[i];
                        tempFilename = filename[i];
                        tempYear = year[i];

                        duration[i] = duration[j];
                        title[i] = title[j];
                        singer[i] = singer[j];
                        filename[i] = filename[j];
                        year[i] = year[j];

                        duration[j] = tempDuration;
                        title[j] = tempTitle;
                        singer[j] = tempSinger;
                        filename[j] = tempFilename;
                        year[j] = tempYear;
                    }
                }
            }
            return "DESCENDING";
        }
        return "";
    }

    public int searchTitle(String search, int size, int resume) {
        boolean found = false;
        String[] check = search.split(" ");
        int sizeCheck = check.length;
        for (int i = resume; i < size; i++) {
            String titleSubstring[] = title[i].split(" ");
            int substringSize = titleSubstring.length;
            for (int j = 0; j < substringSize; j++) {
                for (int k = 0; k < sizeCheck; k++) {
                    found = titleSubstring[j].equalsIgnoreCase(check[k]);
                    if (found) {
                        j++;
                        continue;
                    } else {
                        j = j - k;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return size;
    }

    public int searchSinger(String search, int size, int resume) {
        boolean found = false;
        String[] check = search.split(" ");
        int sizeCheck = check.length;
        for (int i = resume; i < size; i++) {
            String singerSubstring[] = singer[i].split(" ");
            int substringSize = singerSubstring.length;
            for (int j = 0; j < substringSize; j++) {
                for (int k = 0; k < sizeCheck; k++) {
                    found = singerSubstring[j].equalsIgnoreCase(check[k]);
                    if (found) {
                        j++;
                        continue;
                    } else {
                        j = j - k;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return size;
    }

    public String toString(int i) {
        return "Now Playing\n" + "Title : " + title[i] + "\nSinger : " + singer[i] + "\nFilename : " + filename[i] + "\nDuration : " + duration[i] + " minutes\nYear Published : " + year[i] + "\n";
    }

    public static void main(String[] args) {
        String[] title = {"For The Rest Of My Life", "Let It Go", "Kenshi Yonezu", "You Are My Life", "Insha Allah"};
        String[] singer = {"Maher Zain", "Elsa", "Lemon", "Harris J", "Maher Zain"};
        String[] filename = {"For_The_Rest_Of_My_Life.mp3", "Let_It_Go.mp3", "Kenshi_Yonezu.mp3", "You_Are_My_Life.mp3", "InshaAllah.mp3"};
        double[] duration = {4.35, 4.11, 4.22, 4.43, 4.00};
        int[] year = {2010, 2017, 2018, 2017, 2015};
        int size = title.length;
        Scanner scan = new Scanner(System.in);
        Song s = new Song(title, singer, filename, duration, year);
        for (;;) {
            System.out.println("Welcome To Music Player\n(Insert 0 to exit)\n");
            System.out.println("1. Play\n2. Sort by Title\n3. Sort by Duration\n4. Search by Title\n5. Search by Singer\nWhat would you like to do? \n(Insert Integer[i.e : 1])");
            int Action1 = scan.nextInt();
            switch (Action1) {
                case 1:
                    int i = 0;
                    s.play(i);
                    for (;;) {
                        System.out.println("\nChoose action\n1. Next\n2. Previous\n3. Stop");
                        int Action2 = scan.nextInt();
                        switch (Action2) {
                            case 1:
                                i = s.next(++i, size);
                                continue;
                            case 2:
                                i = s.previous(--i, size);
                                continue;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid input\n");
                                continue;
                        }
                        break;
                    }
                    break;
                case 2:
                    for (;;) {
                        System.out.println("\nSort title in what order ?\n1. Ascending\n2. Descending");
                        int ascdsc = scan.nextInt();
                        if (ascdsc == 1 || ascdsc == 2) {
                            String order = s.sortTitle(ascdsc, size);
                            System.out.println("Songs have been sorted by TITLE in " + order + " order !");
                            break;
                        } else {
                            System.out.println("Invalid input\n");
                        }
                    }
                    break;
                case 3:
                    for (;;) {
                        System.out.println("\nSort duration in what order ?\n1. Ascending\n2. Descending");
                        int ascdsc = scan.nextInt();
                        if (ascdsc == 1 || ascdsc == 2) {
                            String order = s.sortDuration(ascdsc, size);
                            System.out.println("Songs have been sorted by DURATION in " + order + " order !");
                            break;
                        } else {
                            System.out.println("Invalid input\n");
                        }
                    }
                    break;
                case 4:
                    OUTER:
                    for (;;) {
                        boolean notfound = true;
                        System.out.print("Insert Title : ");
                        scan.nextLine();
                        String searchTitle = scan.nextLine();
                        int result = 0;
                        OUT:
                        for (;;) {
                            result = s.searchTitle(searchTitle, size, result);
                            if (result < size) {
                                s.play(result++);
                                notfound = false;
                            } else if (notfound) {
                                System.out.println("Result not found");
                                break;
                            } else {
                                System.out.println("End of search result");
                                break;
                            }
                            for (;;) {
                                System.out.println("What would you like to do?\n1. Next result\n2. End search");
                                int Action3 = scan.nextInt();
                                if (Action3 == 1) {
                                    break;
                                } else if (Action3 == 2) {
                                    break OUT;
                                } else {
                                    System.out.println("Invalid Input");
                                }

                            }
                        }
                        for (;;) {
                            System.out.println("What would you like to do?\n1. New search\n2. Exit search");
                            int Action4 = scan.nextInt();
                            if (Action4 == 1) {
                                break;
                            }
                            if (Action4 == 2) {
                                break OUTER;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                    break;
                case 5:
                    OUTER:
                    for (;;) {
                        boolean notfound = true;
                        System.out.print("Insert Singer : ");
                        scan.nextLine();
                        String searchSinger = scan.nextLine();
                        int result = 0;
                        OUT:
                        for (;;) {
                            result = s.searchSinger(searchSinger, size, result);
                            if (result < size) {
                                s.play(result++);
                                notfound = false;
                            } else if (notfound) {
                                System.out.println("Result not found");
                                break;
                            } else {
                                System.out.println("End of search result");
                                break;
                            }
                            for (;;) {
                                System.out.println("What would you like to do?\n1. Next result\n2. End search");
                                int Action3 = scan.nextInt();
                                if (Action3 == 1) {
                                    break;
                                } else if (Action3 == 2) {
                                    break OUT;
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            }
                        }
                        for (;;) {
                            System.out.println("What would you like to do?\n1. New search\n2. Exit search");
                            int Action4 = scan.nextInt();
                            if (Action4 == 1) {
                                break;
                            } else if (Action4 == 2) {
                                break OUTER;
                            } else {
                                System.out.println("Invalid Input");
                                continue;
                            }
                        }

                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid input\n");
                    continue;
            }
        }
    }
}
