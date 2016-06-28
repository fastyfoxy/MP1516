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
public class Accounts extends org.jooq.impl.TableImpl<mineplex.database.tables.records.AccountsRecord> implements java.io.Serializable, java.lang.Cloneable {

	private static final long serialVersionUID = 1091419892;

	/**
	 * The reference instance of <code>Account.accounts</code>
	 */
	public static final mineplex.database.tables.Accounts accounts = new mineplex.database.tables.Accounts();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<mineplex.database.tables.records.AccountsRecord> getRecordType() {
		return mineplex.database.tables.records.AccountsRecord.class;
	}

	/**
	 * The column <code>Account.accounts.id</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.Integer> id = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>Account.accounts.uuid</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.String> uuid = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>Account.accounts.name</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.String> name = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(40), this, "");

	/**
	 * The column <code>Account.accounts.gems</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.Integer> gems = createField("gems", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.gold</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.Integer> gold = createField("gold", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.coins</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.Integer> coins = createField("coins", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.donorRank</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.String> donorRank = createField("donorRank", org.jooq.impl.SQLDataType.VARCHAR.length(20).defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.rank</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.String> rank = createField("rank", org.jooq.impl.SQLDataType.VARCHAR.length(20).defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.rankPerm</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.Byte> rankPerm = createField("rankPerm", org.jooq.impl.SQLDataType.TINYINT, this, "");

	/**
	 * The column <code>Account.accounts.rankExpire</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.sql.Timestamp> rankExpire = createField("rankExpire", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.lastLogin</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.sql.Timestamp> lastLogin = createField("lastLogin", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>Account.accounts.totalPlayTime</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.AccountsRecord, java.lang.String> totalPlayTime = createField("totalPlayTime", org.jooq.impl.SQLDataType.CLOB.length(16777215), this, "");

	/**
	 * Create a <code>Account.accounts</code> table reference
	 */
	public Accounts() {
		this("accounts", null);
	}

	/**
	 * Create an aliased <code>Account.accounts</code> table reference
	 */
	public Accounts(java.lang.String alias) {
		this(alias, mineplex.database.tables.Accounts.accounts);
	}

	private Accounts(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.AccountsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Accounts(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.AccountsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, mineplex.database.Account.Account, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<mineplex.database.tables.records.AccountsRecord, java.lang.Integer> getIdentity() {
		return mineplex.database.Keys.IDENTITY_accounts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<mineplex.database.tables.records.AccountsRecord> getPrimaryKey() {
		return mineplex.database.Keys.KEY_accounts_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<mineplex.database.tables.records.AccountsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<mineplex.database.tables.records.AccountsRecord>>asList(mineplex.database.Keys.KEY_accounts_PRIMARY, mineplex.database.Keys.KEY_accounts_uuidIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public mineplex.database.tables.Accounts as(java.lang.String alias) {
		return new mineplex.database.tables.Accounts(alias, this);
	}

	/**
	 * Rename this table
	 */
	public mineplex.database.tables.Accounts rename(java.lang.String name) {
		return new mineplex.database.tables.Accounts(name, null);
	}
}
