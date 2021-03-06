package biz.advancedcalendar.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** DAO for table TASK. */
public class TaskDao extends AbstractDao<Task, Long> {
	public static final String TABLENAME = "TASK";

	/** Properties of entity Task.<br/>
	 * Can be used for QueryBuilder and for referencing column names. */
	public static class Properties {
		public final static Property Id = new Property(0, Long.class, "id", true, "_id");
		public final static Property CalendarId = new Property(1, Long.class,
				"calendarId", false, "CALENDAR_ID");
		public final static Property ParentId = new Property(2, Long.class, "parentId",
				false, "PARENT_ID");
		public final static Property LocalCreateDateTime = new Property(3, long.class,
				"localCreateDateTime", false, "LOCAL_CREATE_DATE_TIME");
		public final static Property LocalChangeDateTime = new Property(4, long.class,
				"localChangeDateTime", false, "LOCAL_CHANGE_DATE_TIME");
		public final static Property ServerId = new Property(5, Long.class, "serverId",
				false, "SERVER_ID");
		public final static Property Created = new Property(6, Long.class, "created",
				false, "CREATED");
		public final static Property LastMod = new Property(7, Long.class, "lastMod",
				false, "LAST_MOD");
		public final static Property SyncStatusValue = new Property(8, byte.class,
				"syncStatusValue", false, "SYNC_STATUS");
		public final static Property Name = new Property(9, String.class, "name", false,
				"NAME");
		public final static Property Priority = new Property(10, short.class, "priority",
				false, "PRIORITY");
		public final static Property Color = new Property(11, Integer.class, "color",
				false, "COLOR");
		public final static Property StartDateTime = new Property(12, Long.class,
				"startDateTime", false, "START_DATE_TIME");
		public final static Property EndDateTime = new Property(13, Long.class,
				"endDateTime", false, "END_DATE_TIME");
		public final static Property RequiredLength = new Property(14, Integer.class,
				"requiredLength", false, "REQUIRED_LENGTH");
		public final static Property ActualLength = new Property(15, Integer.class,
				"actualLength", false, "ACTUAL_LENGTH");
		public final static Property IsCompleted = new Property(16, boolean.class,
				"isCompleted", false, "IS_COMPLETED");
		public final static Property PercentOfCompletion = new Property(17, short.class,
				"percentOfCompletion", false, "PERCENT_OF_COMPLETION");
		public final static Property CompletedTime = new Property(18, Long.class,
				"completedTime", false, "COMPLETED_TIME");
		public final static Property Deleted = new Property(19, boolean.class, "deleted",
				false, "DELETED");
		public final static Property SortOrder = new Property(20, int.class, "sortOrder",
				false, "SORT_ORDER");
		public final static Property Description = new Property(21, String.class,
				"description", false, "DESCRIPTION");
		public final static Property Location = new Property(22, String.class,
				"location", false, "LOCATION");
		public final static Property RecurrenceIntervalValue = new Property(23,
				short.class, "recurrenceIntervalValue", false, "RECURRENCE_INTERVAL");
		public final static Property TimeUnitsCount = new Property(24, Integer.class,
				"timeUnitsCount", false, "TIME_UNITS_COUNT");
		public final static Property OccurrencesMaxCount = new Property(25,
				Integer.class, "occurrencesMaxCount", false, "OCCURRENCES_MAX_COUNT");
		public final static Property RepetitionEndDateTime = new Property(26, Long.class,
				"repetitionEndDateTime", false, "REPETITION_END_DATE_TIME");
		public final static Property AlarmRingtone = new Property(27, String.class,
				"alarmRingtone", false, "ALARM_RINGTONE");
		public final static Property NotificationRingtone = new Property(28,
				String.class, "notificationRingtone", false, "NOTIFICATION_RINGTONE");
		public final static Property RingtoneFadeInTime = new Property(37, Long.class,
				"ringtoneFadeInTime", false, "RINGTONE_FADE_IN_TIME");
		public final static Property PlayingTime = new Property(29, Integer.class,
				"playingTime", false, "PLAYING_TIME");
		public final static Property AutomaticSnoozeDuration = new Property(30,
				Integer.class, "automaticSnoozeDuration", false,
				"AUTOMATIC_SNOOZE_DURATION");
		public final static Property AutomaticSnoozesMaxCount = new Property(31,
				Integer.class, "automaticSnoozesMaxCount", false,
				"AUTOMATIC_SNOOZES_MAX_COUNT");
		public final static Property Vibrate = new Property(32, Boolean.class, "vibrate",
				false, "VIBRATE");
		public final static Property VibratePattern = new Property(33, String.class,
				"vibratePattern", false, "VIBRATE_PATTERN");
		public final static Property Led = new Property(34, Boolean.class, "led", false,
				"LED");
		public final static Property LedPattern = new Property(35, String.class,
				"ledPattern", false, "LED_PATTERN");
		public final static Property LedColor = new Property(36, Integer.class,
				"ledColor", false, "LED_COLOR");
	};

	private DaoSession daoSession;

	public TaskDao(DaoConfig config) {
		super(config);
	}

	public TaskDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
		this.daoSession = daoSession;
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint + "'TASK' (" + //
				"'_id' INTEGER PRIMARY KEY ," + // 0: id
				"'CALENDAR_ID' INTEGER," + // 1: calendarId
				"'PARENT_ID' INTEGER," + // 2: parentId
				"'LOCAL_CREATE_DATE_TIME' INTEGER NOT NULL ," + // 3: localCreateDateTime
				"'LOCAL_CHANGE_DATE_TIME' INTEGER NOT NULL ," + // 4: localChangeDateTime
				"'SERVER_ID' INTEGER," + // 5: serverId
				"'CREATED' INTEGER," + // 6: created
				"'LAST_MOD' INTEGER," + // 7: lastMod
				"'SYNC_STATUS' INTEGER NOT NULL ," + // 8: syncStatusValue
				"'NAME' TEXT NOT NULL ," + // 9: name
				"'PRIORITY' INTEGER NOT NULL ," + // 10: priority
				"'COLOR' INTEGER," + // 11: color
				"'START_DATE_TIME' INTEGER," + // 12: startDateTime
				"'END_DATE_TIME' INTEGER," + // 13: endDateTime
				"'REQUIRED_LENGTH' INTEGER," + // 14: requiredLength
				"'ACTUAL_LENGTH' INTEGER," + // 15: actualLength
				"'IS_COMPLETED' INTEGER NOT NULL ," + // 16: isCompleted
				"'PERCENT_OF_COMPLETION' INTEGER NOT NULL ," + // 17: percentOfCompletion
				"'COMPLETED_TIME' INTEGER," + // 18: completedTime
				"'DELETED' INTEGER NOT NULL ," + // 19: deleted
				"'SORT_ORDER' INTEGER NOT NULL ," + // 20: sortOrder
				"'DESCRIPTION' TEXT," + // 21: description
				"'LOCATION' TEXT," + // 22: location
				"'RECURRENCE_INTERVAL' INTEGER NOT NULL ," + // 23:
																// recurrenceIntervalValue
				"'TIME_UNITS_COUNT' INTEGER," + // 24: timeUnitsCount
				"'OCCURRENCES_MAX_COUNT' INTEGER," + // 25: occurrencesMaxCount
				"'REPETITION_END_DATE_TIME' INTEGER," + // 26: repetitionEndDateTime
				"'ALARM_RINGTONE' TEXT," + // 27: alarmRingtone
				"'NOTIFICATION_RINGTONE' TEXT," + // 28: notificationRingtone
				"'PLAYING_TIME' INTEGER," + // 29: playingTime
				"'AUTOMATIC_SNOOZE_DURATION' INTEGER," + // 30: automaticSnoozeDuration
				"'AUTOMATIC_SNOOZES_MAX_COUNT' INTEGER," + // 31: automaticSnoozesMaxCount
				"'VIBRATE' INTEGER," + // 32: vibrate
				"'VIBRATE_PATTERN' TEXT," + // 33: vibratePattern
				"'LED' INTEGER," + // 34: led
				"'LED_PATTERN' TEXT," + // 35: ledPattern
				"'LED_COLOR' INTEGER," + // 36: ledColor
				"'RINGTONE_FADE_IN_TIME' INTEGER);"); // 37: ringtoneFadeInTime
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TASK'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt, Task entity) {
		stmt.clearBindings();
		Long id = entity.getId();
		if (id != null) {
			stmt.bindLong(1, id);
		}
		Long calendarId = entity.getCalendarId();
		if (calendarId != null) {
			stmt.bindLong(2, calendarId);
		}
		Long parentId = entity.getParentId();
		if (parentId != null) {
			stmt.bindLong(3, parentId);
		}
		stmt.bindLong(4, entity.getLocalCreateDateTime());
		stmt.bindLong(5, entity.getLocalChangeDateTime());
		Long serverId = entity.getServerId();
		if (serverId != null) {
			stmt.bindLong(6, serverId);
		}
		Long created = entity.getCreated();
		if (created != null) {
			stmt.bindLong(7, created);
		}
		Long lastMod = entity.getLastMod();
		if (lastMod != null) {
			stmt.bindLong(8, lastMod);
		}
		stmt.bindLong(9, entity.getSyncStatusValue());
		stmt.bindString(10, entity.getName());
		stmt.bindLong(11, entity.getPriority());
		Integer color = entity.getColor();
		if (color != null) {
			stmt.bindLong(12, color);
		}
		Long startDateTime = entity.getStartDateTime();
		if (startDateTime != null) {
			stmt.bindLong(13, startDateTime);
		}
		Long endDateTime = entity.getEndDateTime();
		if (endDateTime != null) {
			stmt.bindLong(14, endDateTime);
		}
		Integer requiredLength = entity.getRequiredLength();
		if (requiredLength != null) {
			stmt.bindLong(15, requiredLength);
		}
		Integer actualLength = entity.getActualLength();
		if (actualLength != null) {
			stmt.bindLong(16, actualLength);
		}
		stmt.bindLong(17, entity.getIsCompleted() ? 1l : 0l);
		stmt.bindLong(18, entity.getPercentOfCompletion());
		Long completedTime = entity.getCompletedTime();
		if (completedTime != null) {
			stmt.bindLong(19, completedTime);
		}
		stmt.bindLong(20, entity.getDeleted() ? 1l : 0l);
		stmt.bindLong(21, entity.getSortOrder());
		String description = entity.getDescription();
		if (description != null) {
			stmt.bindString(22, description);
		}
		String location = entity.getLocation();
		if (location != null) {
			stmt.bindString(23, location);
		}
		stmt.bindLong(24, entity.getRecurrenceIntervalValue());
		Integer timeUnitsCount = entity.getTimeUnitsCount();
		if (timeUnitsCount != null) {
			stmt.bindLong(25, timeUnitsCount);
		}
		Integer occurrencesMaxCount = entity.getOccurrencesMaxCount();
		if (occurrencesMaxCount != null) {
			stmt.bindLong(26, occurrencesMaxCount);
		}
		Long repetitionEndDateTime = entity.getRepetitionEndDateTime();
		if (repetitionEndDateTime != null) {
			stmt.bindLong(27, repetitionEndDateTime);
		}
		String alarmRingtone = entity.getAlarmRingtone();
		if (alarmRingtone != null) {
			stmt.bindString(28, alarmRingtone);
		}
		String notificationRingtone = entity.getNotificationRingtone();
		if (notificationRingtone != null) {
			stmt.bindString(29, notificationRingtone);
		}
		Long ringtoneFadeInTime = entity.getRingtoneFadeInTime();
		if (ringtoneFadeInTime != null) {
			stmt.bindLong(38, ringtoneFadeInTime);
		}
		Integer playingTime = entity.getPlayingTime();
		if (playingTime != null) {
			stmt.bindLong(30, playingTime);
		}
		Integer automaticSnoozeDuration = entity.getAutomaticSnoozeDuration();
		if (automaticSnoozeDuration != null) {
			stmt.bindLong(31, automaticSnoozeDuration);
		}
		Integer automaticSnoozesMaxCount = entity.getAutomaticSnoozesMaxCount();
		if (automaticSnoozesMaxCount != null) {
			stmt.bindLong(32, automaticSnoozesMaxCount);
		}
		Boolean vibrate = entity.getVibrate();
		if (vibrate != null) {
			stmt.bindLong(33, vibrate ? 1l : 0l);
		}
		String vibratePattern = entity.getVibratePattern();
		if (vibratePattern != null) {
			stmt.bindString(34, vibratePattern);
		}
		Boolean led = entity.getLed();
		if (led != null) {
			stmt.bindLong(35, led ? 1l : 0l);
		}
		String ledPattern = entity.getLedPattern();
		if (ledPattern != null) {
			stmt.bindString(36, ledPattern);
		}
		Integer ledColor = entity.getLedColor();
		if (ledColor != null) {
			stmt.bindLong(37, ledColor);
		}
	}

	@Override
	protected void attachEntity(Task entity) {
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
	public Task readEntity(Cursor cursor, int offset) {
		Task entity = new Task( //
				cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
				cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // calendarId
				cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // parentId
				cursor.getLong(offset + 3), // localCreateDateTime
				cursor.getLong(offset + 4), // localChangeDateTime
				cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // serverId
				cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // created
				cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // lastMod
				(byte) cursor.getShort(offset + 8), // syncStatusValue
				cursor.getString(offset + 9), // name
				cursor.getShort(offset + 10), // priority
				cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // color
				cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12), // startDateTime
				cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // endDateTime
				cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // requiredLength
				cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // actualLength
				cursor.getShort(offset + 16) != 0, // isCompleted
				cursor.getShort(offset + 17), // percentOfCompletion
				cursor.isNull(offset + 18) ? null : cursor.getLong(offset + 18), // completedTime
				cursor.getShort(offset + 19) != 0, // deleted
				cursor.getInt(offset + 20), // sortOrder
				cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // description
				cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // location
				cursor.getShort(offset + 23), // recurrenceIntervalValue
				cursor.isNull(offset + 24) ? null : cursor.getInt(offset + 24), // timeUnitsCount
				cursor.isNull(offset + 25) ? null : cursor.getInt(offset + 25), // occurrencesMaxCount
				cursor.isNull(offset + 26) ? null : cursor.getLong(offset + 26), // repetitionEndDateTime
				cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // alarmRingtone
				cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // notificationRingtone
				cursor.isNull(offset + 37) ? null : cursor.getLong(offset + 37), // playingTime
				cursor.isNull(offset + 29) ? null : cursor.getInt(offset + 29), // automaticSnoozeDuration
				cursor.isNull(offset + 30) ? null : cursor.getInt(offset + 30), // automaticSnoozesMaxCount
				cursor.isNull(offset + 31) ? null : cursor.getInt(offset + 31), // vibrate
				cursor.isNull(offset + 32) ? null : cursor.getShort(offset + 32) != 0, // vibratePattern
				cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // led
				cursor.isNull(offset + 34) ? null : cursor.getShort(offset + 34) != 0, // ledPattern
				cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // ledColor
				cursor.isNull(offset + 36) ? null : cursor.getInt(offset + 36) // ringtoneFadeInTime
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor, Task entity, int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setCalendarId(cursor.isNull(offset + 1) ? null : cursor
				.getLong(offset + 1));
		entity.setParentId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
		entity.setLocalCreateDateTime(cursor.getLong(offset + 3));
		entity.setLocalChangeDateTime(cursor.getLong(offset + 4));
		entity.setServerId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
		entity.setCreated(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
		entity.setLastMod(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
		entity.setSyncStatusValue((byte) cursor.getShort(offset + 8));
		entity.setName(cursor.getString(offset + 9));
		entity.setPriority(cursor.getShort(offset + 10));
		entity.setColor(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
		entity.setStartDateTime(cursor.isNull(offset + 12) ? null : cursor
				.getLong(offset + 12));
		entity.setEndDateTime(cursor.isNull(offset + 13) ? null : cursor
				.getLong(offset + 13));
		entity.setRequiredLength(cursor.isNull(offset + 14) ? null : cursor
				.getInt(offset + 14));
		entity.setActualLength(cursor.isNull(offset + 15) ? null : cursor
				.getInt(offset + 15));
		entity.setIsCompleted(cursor.getShort(offset + 16) != 0);
		entity.setPercentOfCompletion(cursor.getShort(offset + 17));
		entity.setCompletedTime(cursor.isNull(offset + 18) ? null : cursor
				.getLong(offset + 18));
		entity.setDeleted(cursor.getShort(offset + 19) != 0);
		entity.setSortOrder(cursor.getInt(offset + 20));
		entity.setDescription(cursor.isNull(offset + 21) ? null : cursor
				.getString(offset + 21));
		entity.setLocation(cursor.isNull(offset + 22) ? null : cursor
				.getString(offset + 22));
		entity.setRecurrenceIntervalValue(cursor.getShort(offset + 23));
		entity.setTimeUnitsCount(cursor.isNull(offset + 24) ? null : cursor
				.getInt(offset + 24));
		entity.setOccurrencesMaxCount(cursor.isNull(offset + 25) ? null : cursor
				.getInt(offset + 25));
		entity.setRepetitionEndDateTime(cursor.isNull(offset + 26) ? null : cursor
				.getLong(offset + 26));
		entity.setAlarmRingtone(cursor.isNull(offset + 27) ? null : cursor
				.getString(offset + 27));
		entity.setNotificationRingtone(cursor.isNull(offset + 28) ? null : cursor
				.getString(offset + 28));
		entity.setRingtoneFadeInTime(cursor.isNull(offset + 37) ? null : cursor
				.getLong(offset + 37));
		entity.setPlayingTime(cursor.isNull(offset + 29) ? null : cursor
				.getInt(offset + 29));
		entity.setAutomaticSnoozeDuration(cursor.isNull(offset + 30) ? null : cursor
				.getInt(offset + 30));
		entity.setAutomaticSnoozesMaxCount(cursor.isNull(offset + 31) ? null : cursor
				.getInt(offset + 31));
		entity.setVibrate(cursor.isNull(offset + 32) ? null : cursor
				.getShort(offset + 32) != 0);
		entity.setVibratePattern(cursor.isNull(offset + 33) ? null : cursor
				.getString(offset + 33));
		entity.setLed(cursor.isNull(offset + 34) ? null
				: cursor.getShort(offset + 34) != 0);
		entity.setLedPattern(cursor.isNull(offset + 35) ? null : cursor
				.getString(offset + 35));
		entity.setLedColor(cursor.isNull(offset + 36) ? null : cursor.getInt(offset + 36));
	}

	/** @inheritdoc */
	@Override
	protected Long updateKeyAfterInsert(Task entity, long rowId) {
		entity.setId(rowId);
		return rowId;
	}

	/** @inheritdoc */
	@Override
	public Long getKey(Task entity) {
		if (entity != null) {
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

	private String selectDeep;

	protected String getSelectDeep() {
		if (selectDeep == null) {
			StringBuilder builder = new StringBuilder("SELECT ");
			SqlUtils.appendColumns(builder, "T", getAllColumns());
			builder.append(',');
			SqlUtils.appendColumns(builder, "T0", daoSession.getCalendarDao()
					.getAllColumns());
			builder.append(',');
			SqlUtils.appendColumns(builder, "T1", daoSession.getTaskDao().getAllColumns());
			builder.append(" FROM TASK T");
			builder.append(" LEFT JOIN CALENDAR T0 ON T.'CALENDAR_ID'=T0.'_id'");
			builder.append(" LEFT JOIN TASK T1 ON T.'PARENT_ID'=T1.'_id'");
			builder.append(' ');
			selectDeep = builder.toString();
		}
		return selectDeep;
	}

	protected Task loadCurrentDeep(Cursor cursor, boolean lock) {
		Task entity = loadCurrent(cursor, 0, lock);
		int offset = getAllColumns().length;
		Calendar calendar = loadCurrentOther(daoSession.getCalendarDao(), cursor, offset);
		entity.setCalendar(calendar);
		offset += daoSession.getCalendarDao().getAllColumns().length;
		Task task = loadCurrentOther(daoSession.getTaskDao(), cursor, offset);
		entity.setTask(task);
		return entity;
	}

	public Task loadDeep(Long key) {
		assertSinglePk();
		if (key == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder(getSelectDeep());
		builder.append("WHERE ");
		SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
		String sql = builder.toString();
		String[] keyArray = new String[] {key.toString()};
		Cursor cursor = db.rawQuery(sql, keyArray);
		try {
			boolean available = cursor.moveToFirst();
			if (!available) {
				return null;
			} else if (!cursor.isLast()) {
				throw new IllegalStateException("Expected unique result, but count was "
						+ cursor.getCount());
			}
			return loadCurrentDeep(cursor, true);
		} finally {
			cursor.close();
		}
	}

	/** Reads all available rows from the given cursor and returns a list of new ImageTO
	 * objects. */
	public List<Task> loadAllDeepFromCursor(Cursor cursor) {
		int count = cursor.getCount();
		List<Task> list = new ArrayList<Task>(count);
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

	protected List<Task> loadDeepAllAndCloseCursor(Cursor cursor) {
		try {
			return loadAllDeepFromCursor(cursor);
		} finally {
			cursor.close();
		}
	}

	/** A raw-style query where you can pass any WHERE clause and arguments. */
	public List<Task> queryDeep(String where, String... selectionArg) {
		Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
		return loadDeepAllAndCloseCursor(cursor);
	}
}
