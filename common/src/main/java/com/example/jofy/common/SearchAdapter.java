package com.example.jofy.common;


public class SearchAdapter{
    private String title;
    private String isdn;
    private String category;
    private String author;

    public SearchAdapter()
    {
        title = "";
        isdn = "";
        category = "";
        author = "";
    }

    public String getIsdn() {
        return isdn;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
/*
    @Test
    public void testConnection() {
        Connection con = new Connection("z3950.indexdata.dk:210/gils", 0);
        assertNotNull(con);
        try {
            con.setSyntax("sutrs");
            System.out.println("Open connection to z3950.indexdata.dk:210/gils...");
            con.connect();
            ResultSet s = con.search(new PrefixQuery("@attr 1=4 utah"));
            System.out.println("Search for 'utah'...");
            assertNotNull(s);
            assertEquals(s.getHitCount(), 9);
            Record rec = s.getRecord(0);
            assertNotNull(rec);
            byte[] content = rec.getContent();
            // first SUTRS record
            assertEquals(content.length, 1940);
            assertEquals(content[0], 103);
            assertEquals(rec.getSyntax(), "SUTRS");
            assertEquals(rec.getDatabase(), "gils");
            System.out.println("Read all records..");
            // read all records
            int i = 0;
            for (Record r : s) {
                assertNotNull(r);
                System.out.println("Got "+i+" record of type "+r.getSyntax());
                i++;
            }
            System.out.println("Try sorting them...");
            s.sort("yaz", "1=4 >i 1=21 >s");
            System.out.println("Try fetching them all at once...");
            i = 0;
            List<Record> all = s.getRecords(0, (int) s.getHitCount());
            for (Record r : all) {
                System.out.println("getRecords, rec '"+i+"'"+r.getSyntax());
                i++;
            }
        } catch (ZoomException ze) {
            fail(ze.getMessage());
        } finally {
            con.close();
        }
    }*/




    public static void vypis(String vypis){
        System.out.println(vypis);
    }
}
