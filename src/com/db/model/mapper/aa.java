/*package com.db.model.mapper;

public class MediaPlatformMetadataRSExtractor implements ResultSetExtractor<List<MediaPlatform>> {

	@Override
	public List<MediaPlatform> extractData(ResultSet rs) throws SQLException{

		List<MediaPlatform> platformList = new ArrayList<>(5);
		MediaDocType docType = null;
		while (rs.next()) {
			docType = null;
			String platformName = rs.getString("PlatformName");
			String docSourceCode = rs.getString("docsource_code");
			String docTypeCode = rs.getString("doctype_code");
			String intervalCmskey = rs.getString("interval_cmskey");

			MediaPlatform platform = platformList.stream().filter(x -> platformName.equals(x.getName())).findAny()
					.orElse(null);
			if (platform == null) {
				platform = new MediaPlatform();
				platform.setName(platformName);
				platform.setSource(new ArrayList<>());
				platformList.add(platform);
			}

			MediaDocSource docSource = platform.getSource().stream().filter(x -> docSourceCode.equals(x.getCode()))
					.findAny().orElse(null);
			if (docSource == null) {
				docSource = new MediaDocSource();
				docSource.setCmskey(rs.getString("docsource_cmskey"));
				docSource.setCode(docSourceCode);
				docSource.setDoctype(new ArrayList<>());
				platform.getSource().add(docSource);
			}

			if (docTypeCode != null) {
				docType = docSource.getDoctype().stream().filter(x -> docTypeCode.equals(x.getCode())).findAny()
						.orElse(null);
				if (docType == null) {
					docType = new MediaDocType();
					docType.setCmskey(rs.getString("doctype_cmskey"));
					docType.setCode(docTypeCode.trim());
					docType.setActive(rs.getBoolean("doctype_active"));
					docType.setCreateDate(rs.getTimestamp("doctype_createdate"));
					if (intervalCmskey != null) {
						docType.setTimeperiod(new ArrayList<>());
					}
					docSource.getDoctype().add(docType);
				}
			}

			if (docType != null && intervalCmskey != null) {
				if (docType.getTimeperiod() == null) {
					docType.setTimeperiod(new ArrayList<>());
				}
				MediaDocInterval docInterval = docType.getTimeperiod().stream()
						.filter(x -> intervalCmskey.equals(x.getCmskey())).findAny().orElse(null);
				if (docInterval == null) {
					docInterval = new MediaDocInterval();
					docInterval.setCmskey(intervalCmskey);
					docInterval.setUnit(rs.getString("unit"));
					docInterval.setValue(rs.getInt("value"));
					docType.getTimeperiod().add(docInterval);
				}
			}
		}
		return platformList;

	}
}
*/