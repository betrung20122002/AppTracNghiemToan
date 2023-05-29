package com.example.um;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.um.model.Category;
import com.example.um.model.Question;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    //ten databse
    private static final String DATABASE_NAME = "Question.db";
    //vertion
    private static final int VERTION = 1;

    private SQLiteDatabase db;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        this.db = sqLiteDatabase;

        //biến bảng chuyên mục
        final String CATEGORIES_TABLE = "CREATE TABLE " +
                Table.CategoriesTable.TABLE_NAME + "( " +
                Table.CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Table.CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";
        //biến bảng question
        final String QUESTIONS_TABLE = "CREATE TABLE " +
                Table.QuestionsTable.TABLE_NAME + " ( " +
                Table.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Table.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                Table.QuestionsTable.COLUMN_ANSWER + " INTEGER, " +
                Table.QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + Table.QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                Table.CategoriesTable.TABLE_NAME + "(" + Table.CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        //tao bang
        db.execSQL(CATEGORIES_TABLE);
        db.execSQL(QUESTIONS_TABLE);

        //insert du lieu
        CreatCategories();
        CreateQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " +Table.CategoriesTable.COLUMN_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +Table.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    //insert chu de vao co so du lieu
    private void insertCategories(Category category){
        ContentValues values = new ContentValues();
        values.put(Table.CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(Table.CategoriesTable.TABLE_NAME, null,values);
    }

    //cac gia trin insert
    private void CreatCategories(){
        //mon toan id = 1
        Category c1 = new Category("Tổng hợp");
        insertCategories(c1);
        //mon toan id = 2
        Category c2 = new Category("Toán hình");
        insertCategories(c2);
        //mon toan id = 3
        Category c3 = new Category("Đại số");
        insertCategories(c3);
    }
    //insert cau hoi vao dap an vao ccsdl
    private void insertQuestion(Question question){
        ContentValues values = new ContentValues();

        values.put(Table.QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        values.put(Table.QuestionsTable.COLUMN_OPTION1,question.getOption1());
        values.put(Table.QuestionsTable.COLUMN_OPTION2,question.getOption2());
        values.put(Table.QuestionsTable.COLUMN_OPTION3,question.getOption3());
        values.put(Table.QuestionsTable.COLUMN_OPTION4,question.getOption4());
        values.put(Table.QuestionsTable.COLUMN_ANSWER,question.getAnswer());
        values.put(Table.QuestionsTable.COLUMN_CATEGORY_ID,question.getCategoryID());

        db.insert(Table.QuestionsTable.TABLE_NAME,null,values);
    }
    //tao du lieu bang cau hoi
    private void CreateQuestions(){
        //du lieu bang question
        //gom cau hoi
        //4 dap an
        //vi tri chu de: 1-A ,2_B,3-C,4_D
        //id cua chu de
        //Dữ liệu bảng question
        // Database của tổng hợp
        Question q1 = new Question("Trong các mệnh đề sau, mệnh đề nào đúng?" +
                "Khối đa diện có các mặt là những tam giác thì:",
                "A. Số mặt và số đỉnh của nó bằng nhau",
                "B. Số mặt và số cạnh của nó bằng nhau",
                "C. Số mặt của nó là một số chẵn",
                "D. Số mặt của nó là một số lẻ", 3, 1);
        insertQuestion(q1);
        Question q2 = new Question("Cho mặt cầu (S) tâm O bán kính R và một mặt phẳng (P). Kí hiệu h là khoảng cách từ O đến mặt phẳng (P). Mặt phẳng (P) và mặt cầu (S) có điểm chung nếu và chỉ nếu :",
                "A. h < R",
                "B. h = R",
                "C. h ≤ R",
                " D. h ≥ R", 4, 1);
        insertQuestion(q2);
        Question q3 = new Question("Trong không gian cho đường thẳng Δ và điểm O cách Δ một khoảng bằng 20cm. Mặt cầu (S) tâm O cắt đường thẳng Δ theo một dây có độ dài 30cm có bán kính r bằng :",
                "A. r = 45cm", "B. r = 30cm", "C. r = 25cm","D. r = 20cm", 3, 1);
        insertQuestion(q3);

        Question q4 = new Question("Cho hình chóp tam giác đều S.ABC có SA tạo với đáy một góc bằng 30o và SA=2a. Trong các điểm S, B, C điểm nào nằm trong mặt cầu tâm A bán kính 3a.",
                "A. Không điểm nào", "B. Chỉ điểm S", "C. Chỉ hai điểm B và C ","D. Cả ba điểm", 3, 1);
        insertQuestion(q4);

        Question q5 = new Question("Cho hình chóp S.ABC có đáy là tam giác vuôg cân đỉnh B và BC = a, SA ⊥ (ABC), SA = 2a. Khẳng định nào sau đây là đúng?",
                "A. Điểm S nằm trong mặt cầu tâm A bán kính a", "B. Điểm S nằm ngoài mặt cầu tâm A bán kính 2a", "C. Điểm C nằm trong mặt cầu tâm A bán kính 2a","D. Cả ba điểm S, B, C cùng nằm trong mặt cầu tâm A bán kính 2a", 3, 1);
        insertQuestion(q5);

        Question q6 = new Question("Trong các mệnh đề sau, mệnh đề nào sai?",
                "A. Hình chóp có mặt cầu ngoại tiếp khi và chỉ khi hình chóp có đáy là một tứ giác nội tiếp được đường tròn.", "B. Hình chóp có mặt cầu ngoại tiếp nếu nó là hình chóp tam giác", "C. Hình chóp có mặt cầu ngoại tiếp nếu nó có các cạnh bên bằng nhau.","D. Hình chóp có mặt cầu ngoại tiếp nếu có cạnh bên vuông góc với đáy", 4, 1);
        insertQuestion(q6);
        Question q7 = new Question("Cho hình chóp S.ABC có đáy là tam giác vuôg cân đỉnh B và BC = a, SA ⊥ (ABC), SA = 2a. Khẳng định nào sau đây là đúng?",
                "A. Điểm S nằm trong mặt cầu tâm A bán kính a", "B. Điểm S nằm ngoài mặt cầu tâm A bán kính 2a", "C. Điểm C nằm trong mặt cầu tâm A bán kính 2a","D. Cả ba điểm S, B, C cùng nằm trong mặt cầu tâm A bán kính 2a.", 3, 1);
        insertQuestion(q7);
        Question q8 = new Question("Cho hai quả cầu cùng bán kính là 5cm. Để đựng hai quả cầu Nam phải làm một hình hộp chữ nhật từ bìa carton. Hỏi trong các đáp án dưới đây, Nam cần ít nhất bao nhiêu xen-ti-mét vuông bìa carton để làm được chiếc hộp đó?",
                "A. 300(cm2) ", "B. 1000(cm2)", "C. 250(cm2) ","D. 1250(cm2)", 2, 1);
        insertQuestion(q8);
        Question q9 = new Question("Trong không gian Oxyz, cho hai vectơ u→ = (3; 4; 0), v→ = (2; -1; 2) . Tích vô hướng của hai vectơ u→ và v→ là:",
                "A. 15 ", "B. 2"," C. 3 ","D.0", 2, 1);
        insertQuestion(q9);
        Question q10 = new Question("Phương trình nào dưới đây là phương trình của một mặt cầu?\n" +
                "\n",
                "A. x2 + y2 + z2 - 2x + 4y - 8z - 25 = 0", "B. x2 + y2 + z2 - 2x - 4y - 6z + 15 = 0", "C. 3x2 + 3y2 + 3z2 - 6x - 7y - 8z + 1 = 0","D. (x - 1)2 + (y + 2)2 + (z + 3)2 + 10 = 0", 3, 1);
        insertQuestion(q10);
        Question q11 = new Question("10log7 bằng:" +
                "\n",
                "A.1", "B. 10log7^10", "C. 7","D. log7", 3, 1);
        insertQuestion(q11);
        Question q12 = new Question("Nếu x = (log82)log28 thì log3x bằng:" +
                "\n",
                "A. -3 ", "B. -1/3 ", "C. 1/3"," D. 3\n" +
                "\n", 1, 1);
        insertQuestion(q12);
        Question q13 = new Question("Tính giá trị của biểu thức (log23)(log94)" +
                "\n",
                "A. 2/3 ", " B. 1 ", "C. 3/2"," D. 4" +
                "\n", 2, 1);
        insertQuestion(q13);
        Question q14 = new Question("Cho 2 hàm số f(x) = x2 và g(x) = x1/2 . Biết rằng α > 0, f(α) < g(α). Khẳng định nào sau đây là đúng?" +
                "\n",
                "A. 0 < α < 1/2 ", "B. 0 < α < 1 ", "C. 1/2 < α < 2"," D. α > 1" +
                "\n", 2, 1);
        insertQuestion(q14);
        Question q15 = new Question("Số lượng cá thể của một mẻ cấy vi khuẩn sau t ngày kể từ lúc ban đầu được ước lượng bởi công thức N(t) = 1200.(1,148)t. Hãy tính số lượng cá thể của mẻ vi khuẩn ở hai thời điểm: ban đầu và sau 10 ngày. Làm tròn kết quả đến hàng trăm có kết quả là:" +
                "\n",
                "A. 1200 và 4700 cá thể", "B. 1400 và 4800 cá thể ", "C. 1200 và 1400 cá thể"," D. 1200 và 4800 cá thể" +
                "\n", 4, 1);
        insertQuestion(q15);
        //Database của toán hình
        Question h1 = new Question("Trong các mệnh đề sau, mệnh đề nào đúng?",
                "A. Trong một hình đa diện tổng của số mặt và số cạnh nhỏ hơn số đỉnh.", "B. Trong một hình đa diện tổng của số mặt và số đỉnh lớn hơn số cạnh ", "C. Trong một hình đa diện tổng số cạnh và số đỉnh nhỏ hơn số mặt"," D. Tồn tại một hình đa diện có tổng của số mặt và số đỉnh nhỏ hơn số cạnh" +
                "\n", 2, 2);
        insertQuestion(h1);
        Question h2 = new Question("Trong các mệnh đề sau, mệnh đề nào đúng?",
                "A. Mỗi hình đa diện có ít nhất 8 mặt", "B. Mỗi hình đa diện có ít nhất 6 mặt", "C. Mỗi hình đa diện có ít nhất 5 mặt"," D. Mỗi hình đa diện có ít nhất 4 mặt" +
                "\n", 4, 2);
        insertQuestion(h2);
        Question h3 = new Question("Trong các mệnh đề sau, mệnh đề nào đúng?\n" +
                "\n" +
                "Cho hình đa diện (H) có các mặt là nhứng tam giác, mỗi đỉnh là đỉnh chung của đúng 3 mặt. Gọi số các đỉnh, cạnh, mặt của hình đa diện (H) lần lượt là d, c, m. Khi đó:",
                "A. d > m", "B. d < m", "C. d = m"," D. d + m = c" +
                "\n", 4, 2);
        insertQuestion(h3);
        Question h4 = new Question("Mỗi đỉnh của hình đa diện là đỉnh chung của ít nhất bao nhiêu mặt?",
                "A. 2 mặt", "B. 3 mặt", "C. 4 mặt"," D. 5 mặt" +
                "\n", 2, 2);
        insertQuestion(h4);
        Question h5 = new Question("Có ít nhất bao nhiêu cạnh xuất phát từ mỗi đỉnh của một hình đa diện?",
                "A. 5 cạnh", "B. 4 cạnh", "C. 3 cạnh"," D. 2 cạnh" +
                "\n", 3, 2);
        insertQuestion(h5);
        Question h6 = new Question("Hãy chọn cụm từ (hoặc từ) cho dưới đây để sau khi điền nó vào chỗ trống mệnh đề sau trở thành mệnh đề đúng\n" +
                "\n" +
                "“Số cạnh của một hình đa diện luôn….”",
                "A. Chẵn", "B. Lẻ", "C. Nhỏ hơn hoặc bằng số đỉnh"," D. Lớn hơn hoặc bằng 6" +
                "\n", 3, 2);
        insertQuestion(h6);
        Question h7 = new Question("Trong các mệnh đề sau, mệnh đề nào sai?\n" +
                "\n",
                "A. Số cạnh của một hình đa diện luôn lớn hơn hoặc bằng 6", "B. Số cạnh của một hình đa diện luôn lớn hơn hoặc bằng 7", "C. Số mặt của một hình đa diện luôn lớn hơn hoặc bằng 4"," D. Số đỉnh của một hình đa diện luôn lớn hơn hoặc bằng 4" +
                "\n", 1, 2);
        insertQuestion(h7);
        Question h8 = new Question("Hai hình đa diện bằng nhau khi và chỉ khi:",
                "A. Có phép tịnh tiến biến hình này thành hình kia", "B. Có phép dời hình biến hình này thành hình kia", "C. Có các cạnh tương ứng bằng nhau"," D. Có các mặt tương ứng là các đa giác bằng nhau" +
                "\n", 1, 2);
        insertQuestion(h8);
        Question h9 = new Question("Trong không gian Oxyz, cho d là đường thẳng đi qua điểm , với m là tham số, và song song với hai mặt phẳng (Oxy), (Oxz). Trong những khẳng định dưới đây, khẳng định nào sai?",
                "A. Tồn tại m để d đi qua gốc tọa độ", "B. d có một vectơ chỉ phương là: u→ = (1; 0; 0)", "C. Phương trình chính tắc của d là: x = t, y = -3, z = 4"," D. Đường thẳng d nằm trong hai mặt phẳng: (P): y + 3 = 0, (Q): z - 4 = 0" +
                "\n", 1, 2);
        insertQuestion(h9);
        Question h10 = new Question("Cho hai quả cầu cùng bán kính là 5cm. Để đựng hai quả cầu Nam phải làm một hình hộp chữ nhật từ bìa carton. Hỏi trong các đáp án dưới đây, Nam cần ít nhất bao nhiêu xen-ti-mét vuông bìa carton để làm được chiếc hộp đó?",
                "A. 300(cm2) ", "B. 1000(cm2)", "C. 250(cm2) ","D. 1250(cm2)", 2, 2);
        insertQuestion(h10);
        //Database của đại số
        Question d1 = new Question("Cho hai số phức z1=1+2i;z2=2−3i . Phần ảo của số phức $w = 3z1 - 2z2 $là",
                "A. 12.  ", "B. 11.", "C. 1."," D.12i" +
                "\n", 1, 3);
        insertQuestion(d1);
        Question d2 = new Question("Cho số phức z=−1+3i. Phần thực, phần ảo của z− là",
                "A. -1 và 3", "B. -1 và -3   ", "C. 1 và -3   "," D. -1 và -3i." +
                "\n", 2, 3);
        insertQuestion(d2);
        Question d3 = new Question("Tìm các số thực x, y sao cho (x–2y)+(x+y+4)i=(2x+y)+2yi.",
                "A. x=3,y=1    ", "B. x=3,y=−1 ", "C. x=−3,y=−1  ","D.x=−3,y=1" +
                "\n", 4, 3);
        insertQuestion(d3);
        Question d4 = new Question("Câu 5: Cho số phức z=3+4i. Khẳng định nào sau đây là khẳng định sai?",
                "A. Điểm biểu diễn của z là M(3;4).  ", "B. Môđun của số phức z là 5.", "C. Số phức đối của z là −3−4i."," D. Số phức liên hợp của z là 3−4i." +
                "\n", 1, 3);
        insertQuestion(d4);
        Question d5 = new Question(" Tập hợp các điểm biểu diễn số phức z thòa mãn |z|=|1+i| là",
                "A. Hai điểm    ", "B. Hai đường thẳng", "C. Đường tròn bán kính R=2."," D. Đường tròn bán kính R=2–√" +
                "\n", 4, 3);
        insertQuestion(d5);
        Question d6 = new Question("Cho số phức z thỏa mãn điều kiện:(1+i)z¯−1−3i= 0. Phần ảo của số phức w=1−iz+z là",
                "A. 1.  ", "B. -3. ", "C. -2.   "," D. -1." +
                "\n", 2, 3);
        insertQuestion(d6);
        Question d7 = new Question("Hai điểm biểu diễn hai số phức liên hợp z = 1 + i và z¯ = 1 −i đối xứng nhau qua",
                "A. Trục tung     ", "B. Trục hoành  ", "C. Gốc tọa độ   "," D. Điểm I (1; -1)" +
                "\n", 2, 3);
        insertQuestion(d7);
        Question d8 = new Question("Tập hợp các điểm biểu diễn số phức z thỏa mãn |z|= 2 là",
                "A. Hai đường thẳng   ", "B. Đường tròn bán kính bằng 2", "C. Đường tròn bán kính bằng 4   "," D. Hình tròn bán kính bằng 2." +
                "\n", 2, 3);
        insertQuestion(d8);
        Question d9 = new Question("Cho hàm số \n" +
                "y\n" +
                "=\n" +
                "x\n" +
                "3\n" +
                "+\n" +
                "3\n" +
                "x\n" +
                "+\n" +
                "2\n" +
                ". Mệnh đề nào dưới đây là đúng?",
                "A. Hàm số đồng biến trên khoảng \n" +
                        "(\n" +
                        "−\n" +
                        "∞\n" +
                        ";\n" +
                        "0\n" +
                        ")\n" +
                        " và nghịch biến trên khoảng \n" +
                        "(\n" +
                        "0\n" +
                        ";\n" +
                        "+\n" +
                        "∞\n" +
                        ")\n" +
                        ".  ", "B. Hàm số nghịch biến trên khoảng \n" +
                "(\n" +
                "−\n" +
                "∞\n" +
                ";\n" +
                "+\n" +
                "∞\n" +
                ")\n" +
                ".", "C. Hàm số đồng biến trên khoảng \n" +
                "(\n" +
                "−\n" +
                "∞\n" +
                ";\n" +
                "+\n" +
                "∞\n" +
                ")\n" +
                "."," D. Hàm số nghịch biến trên khoảng \n" +
                "(\n" +
                "−\n" +
                "∞\n" +
                ";\n" +
                "0\n" +
                ")\n" +
                " và đồng biến trên khoảng \n" +
                "(\n" +
                "0\n" +
                ";\n" +
                "+\n" +
                "∞\n" +
                ")\n" +
                "." +
                "\n", 3, 3);
        insertQuestion(d9);
        Question d10 = new Question("Cho hàm số \n" +
                "y\n" +
                "=\n" +
                "x\n" +
                "3\n" +
                "+\n" +
                "3\n" +
                "x\n" +
                "2\n" +
                "+\n" +
                "m\n" +
                "x\n" +
                "+\n" +
                "1\n" +
                "−\n" +
                "2\n" +
                "m\n" +
                ". Tìm các gía trị của m để hàm số đồng biến trên đoạn có độ dài bằng 1.",
                "A. \n" +
                        "m\n" +
                        "=\n" +
                        "0  ", "B. \n" +
                "m\n" +
                "=\n" +
                "1", "C. Không tồn tại"," D. \n" +
                "m\n" +
                "=\n" +
                "−\n" +
                "1" +
                "\n", 3, 3);
        insertQuestion(d10);
    }

    //ham tro ve du lieu cac chu de
    @SuppressLint("Range")
    public List<Category> getDataCategories(){
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+Table.CategoriesTable.TABLE_NAME,null);
        if(c.moveToFirst()){
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(Table.CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(Table.CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            }
            while (c.moveToNext());
        }
        c.close();
        return categoryList;
    }
    //lay du lie cau hoi va dap ân id = id_category theo chu de da chon
    @SuppressLint("Range")
    public ArrayList<Question> getQuestions(int categoryID){
        ArrayList<Question> questionArrayList = new ArrayList<>();

        db = getReadableDatabase();

        String selection = Table.QuestionsTable.COLUMN_CATEGORY_ID+" = ? " ;

        String[] selectionArgs = new String[]{String.valueOf(categoryID)};

        Cursor c = db.query(Table.QuestionsTable.TABLE_NAME,
                null,selection,selectionArgs,null,null,null);

        if (c.moveToFirst()){
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(Table.QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(Table.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(Table.QuestionsTable.COLUMN_ANSWER)));
                question.setCategoryID(c.getInt(c.getColumnIndex(Table.QuestionsTable.COLUMN_CATEGORY_ID)));

                questionArrayList.add(question);

            }
            while (c.moveToNext());
        }
        c.close();
        return questionArrayList;
    }
}
