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
public class ClanAlliances extends org.jooq.impl.TableImpl<mineplex.database.tables.records.ClanAlliancesRecord> implements java.io.Serializable, java.lang.Cloneable {

	private static final long serialVersionUID = 2034100059;

	/**
	 * The reference instance of <code>Account.clanAlliances</code>
	 */
	public static final mineplex.database.tables.ClanAlliances clanAlliances = new mineplex.database.tables.ClanAlliances();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<mineplex.database.tables.records.ClanAlliancesRecord> getRecordType() {
		return mineplex.database.tables.records.ClanAlliancesRecord.class;
	}

	/**
	 * The column <code>Account.clanAlliances.id</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.ClanAlliancesRecord, java.lang.Integer> id = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>Account.clanAlliances.clanId</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.ClanAlliancesRecord, java.lang.Integer> clanId = createField("clanId", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>Account.clanAlliances.otherClanId</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.ClanAlliancesRecord, java.lang.Integer> otherClanId = createField("otherClanId", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>Account.clanAlliances.trusted</code>.
	 */
	public final org.jooq.TableField<mineplex.database.tables.records.ClanAlliancesRecord, java.lang.Boolean> trusted = createField("trusted", org.jooq.impl.SQLDataType.BIT, this, "");

	/**
	 * Create a <code>Account.clanAlliances</code> table reference
	 */
	public ClanAlliances() {
		this("clanAlliances", null);
	}

	/**
	 * Create an aliased <code>Account.clanAlliances</code> table reference
	 */
	public ClanAlliances(java.lang.String alias) {
		this(alias, mineplex.database.tables.ClanAlliances.clanAlliances);
	}

	private ClanAlliances(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.ClanAlliancesRecord> aliased) {
		this(alias, aliased, null);
	}

	private ClanAlliances(java.lang.String alias, org.jooq.Table<mineplex.database.tables.records.ClanAlliancesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, mineplex.database.Account.Account, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<mineplex.database.tables.records.ClanAlliancesRecord, java.lang.Integer> getIdentity() {
		return mineplex.database.Keys.IDENTITY_clanAlliances;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<mineplex.database.tables.records.ClanAlliancesRecord> getPrimaryKey() {
		return mineplex.database.Keys.KEY_clanAlliances_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<mineplex.database.tables.records.ClanAlliancesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<mineplex.database.tables.records.ClanAlliancesRecord>>asList(mineplex.database.Keys.KEY_clanAlliances_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<mineplex.database.tables.records.ClanAlliancesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<mineplex.database.tables.records.ClanAlliancesRecord, ?>>asList(mineplex.database.Keys.clanAlliances_ibfk_2, mineplex.database.Keys.clanAlliances_ibfk_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public mineplex.database.tables.ClanAlliances as(java.lang.String alias) {
		return new mineplex.database.tables.ClanAlliances(alias, this);
	}

	/**
	 * Rename this table
	 */
	public mineplex.database.tables.ClanAlliances rename(java.lang.String name) {
		return new mineplex.database.tables.ClanAlliances(name, null);
	}
}
