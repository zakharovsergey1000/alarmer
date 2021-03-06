package biz.advancedcalendar.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import biz.advancedcalendar.greendao.TaskLabel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TASK_LABEL.
*/
public class TaskLabelDao extends AbstractDao<TaskLabel, Long> {

    public static final String TABLENAME = "TASK_LABEL";

    /**
     * Properties of entity TaskLabel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property TaskId = new Property(1, Long.class, "TaskId", false, "TASK_ID");
        public final static Property LabelId = new Property(2, Long.class, "LabelId", false, "LABEL_ID");
        public final static Property IsVirtual = new Property(3, Boolean.class, "IsVirtual", false, "IS_VIRTUAL");
    };

    private DaoSession daoSession;

    private Query<TaskLabel> task_TaskLabelListQuery;
    private Query<TaskLabel> label_TaskLabelListQuery;

    public TaskLabelDao(DaoConfig config) {
        super(config);
    }
    
    public TaskLabelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TASK_LABEL' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TASK_ID' INTEGER," + // 1: TaskId
                "'LABEL_ID' INTEGER," + // 2: LabelId
                "'IS_VIRTUAL' INTEGER);"); // 3: IsVirtual
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_TASK_LABEL_TASK_ID_LABEL_ID ON TASK_LABEL" +
                " (TASK_ID,LABEL_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TASK_LABEL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TaskLabel entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long TaskId = entity.getTaskId();
        if (TaskId != null) {
            stmt.bindLong(2, TaskId);
        }
 
        Long LabelId = entity.getLabelId();
        if (LabelId != null) {
            stmt.bindLong(3, LabelId);
        }
 
        Boolean IsVirtual = entity.getIsVirtual();
        if (IsVirtual != null) {
            stmt.bindLong(4, IsVirtual ? 1l: 0l);
        }
    }

    @Override
    protected void attachEntity(TaskLabel entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TaskLabel readEntity(Cursor cursor, int offset) {
        TaskLabel entity = new TaskLabel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // TaskId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // LabelId
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0 // IsVirtual
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TaskLabel entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTaskId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setLabelId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setIsVirtual(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TaskLabel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TaskLabel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "taskLabelList" to-many relationship of Task. */
    public List<TaskLabel> _queryTask_TaskLabelList(Long TaskId) {
        synchronized (this) {
            if (task_TaskLabelListQuery == null) {
                QueryBuilder<TaskLabel> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TaskId.eq(null));
                task_TaskLabelListQuery = queryBuilder.build();
            }
        }
        Query<TaskLabel> query = task_TaskLabelListQuery.forCurrentThread();
        query.setParameter(0, TaskId);
        return query.list();
    }

    /** Internal query to resolve the "taskLabelList" to-many relationship of Label. */
    public List<TaskLabel> _queryLabel_TaskLabelList(Long LabelId) {
        synchronized (this) {
            if (label_TaskLabelListQuery == null) {
                QueryBuilder<TaskLabel> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.LabelId.eq(null));
                label_TaskLabelListQuery = queryBuilder.build();
            }
        }
        Query<TaskLabel> query = label_TaskLabelListQuery.forCurrentThread();
        query.setParameter(0, LabelId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTaskDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getLabelDao().getAllColumns());
            builder.append(" FROM TASK_LABEL T");
            builder.append(" LEFT JOIN TASK T0 ON T.'TASK_ID'=T0.'_id'");
            builder.append(" LEFT JOIN LABEL T1 ON T.'LABEL_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected TaskLabel loadCurrentDeep(Cursor cursor, boolean lock) {
        TaskLabel entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Task task = loadCurrentOther(daoSession.getTaskDao(), cursor, offset);
        entity.setTask(task);
        offset += daoSession.getTaskDao().getAllColumns().length;

        Label label = loadCurrentOther(daoSession.getLabelDao(), cursor, offset);
        entity.setLabel(label);

        return entity;    
    }

    public TaskLabel loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<TaskLabel> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<TaskLabel> list = new ArrayList<TaskLabel>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<TaskLabel> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<TaskLabel> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
