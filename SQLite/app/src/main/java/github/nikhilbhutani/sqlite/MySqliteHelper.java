package github.nikhilbhutani.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nikhil Bhutani on 4/26/2016.
 */
public class MySqliteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";

    public static final String DATABASE_NAME = "comments.db";
    public static final int DATABASE_VERSION = 1;

    //Hard coding the Create database SQL statement
    private static final String DATABASE_CREATE = "create table " +TABLE_COMMENTS+ "(" + COLUMN_ID +
            " integer primary key autoincrement, " + COLUMN_COMMENT + " text not null);";

    public MySqliteHelper(Context c)
    {
      super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
           sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        Log.w(MySqliteHelper.class.getName(),
                "Upgrading database from version " + oldversion + " to "
                        + newversion + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(sqLiteDatabase);

    }
}
