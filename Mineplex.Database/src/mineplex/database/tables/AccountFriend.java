/**
 * This class is generated by jOOQ
 */
package mineplex.database.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.2"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountFriend extends org.jooq.impl.TableImpl<mineplex.database.tables.records.AccountFriendRecord> implements java.io.Serializable, java.lang.Cloneable {

	private static final long serialVersionUID = -1948342395;

	/**
	 * The reference instance of <code>Account.accountFriend</code>
	 */
	public static final mineplex.database.tables.AccountFriend accountFriend = new mineplex.database.tables.AccountFriend();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<mineplex.database.tables.records.AccountFriendRecord> getRecordType() {
		return mineplex.database.tables.records.AccountFriendRecord.class;
	}

	/**
	 * The column <code>Account.accountFriend.id</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.lang.Integer> id = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>Account.accountFriend.uuidSource</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.lang.String> uuidSource = createField("uuidSource", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>Account.accountFriend.uuidTarget</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.lang.String> uuidTarget = createField("uuidTarget", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>Account.accountFriend.status</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.lang.String> status = createField("status", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>Account.accountFriend.created</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.sql.Timestamp> created = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>Account.accountFriend.sourceId</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.lang.Integer> sourceId = createField("sourceId", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>Account.accountFriend.targetId</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountFriendRecord, java.lang.Integer> targetId = createField("targetId", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>Account.accountFriend</code> table reference
	 */
	public AccountFriend() {
		this("accountFriend", null);
	}

	/**
	 * Create an aliased <code>Account.accountFriend</code> table reference
	 */
	public AccountFriend(java.lang.String alias) {
		this(alias, mineplex.database.tables.AccountFriend.accountFriend);
	}

	private AccountFriend(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.AccountFriendRecord> aliased) {
		this(alias, aliased, null);
	}

	private AccountFriend(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.AccountFriendRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, mineplex.database.Account.Account, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<mineplex.database.tables.records.AccountFriendRecord, java.lang.Integer> getIdentity() {
		return mineplex.database.Keys.IDENTITY_accountFriend;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<mineplex.database.tables.records.AccountFriendRecord> getPrimaryKey() {
		return mineplex.database.Keys.KEY_accountFriend_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<mineplex.database.tables.records.AccountFriendRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<mineplex.database.tables.records.AccountFriendRecord>>asList(mineplex.database.Keys.KEY_accountFriend_PRIMARY, mineplex.database.Keys.KEY_accountFriend_uuidIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public mineplex.database.tables.AccountFriend as(java.lang.String alias) {
		return new mineplex.database.tables.AccountFriend(alias, this);
	}

	/**
	 * Rename this table
	 */
	public mineplex.database.tables.AccountFriend rename(java.lang.String name) {
		return new mineplex.database.tables.AccountFriend(name, null);
	}
}
