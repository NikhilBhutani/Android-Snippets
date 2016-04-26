package github.nikhilbhutani.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import github.nikhilbhutani.sqlite.Model.Comment;
import github.nikhilbhutani.sqlite.MySqliteHelper;

/**
 * Created by Nikhil Bhutani on 4/27/2016.
 */
public class CommentsDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySqliteHelper dbHelper;
    private String[] allColumns = { MySqliteHelper.COLUMN_ID,
            MySqliteHelper.COLUMN_COMMENT };

    public CommentsDataSource(Context context) {
        dbHelper = new MySqliteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Comment createComment(String comment) {
        ContentValues values = new ContentValues();
        values.put(MySqliteHelper.COLUMN_COMMENT, comment);
        long insertId = database.insert(MySqliteHelper.TABLE_COMMENTS, null,
                values);
        Cursor cursor = database.query(MySqliteHelper.TABLE_COMMENTS,
                allColumns, MySqliteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteComment(Comment comment) {
        long id = comment.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(MySqliteHelper.TABLE_COMMENTS, MySqliteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<Comment>();

        Cursor cursor = database.query(MySqliteHelper.TABLE_COMMENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }

}
