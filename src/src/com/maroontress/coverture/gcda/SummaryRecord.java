package com.maroontress.coverture.gcda;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
   ���ޥ�쥳���ɤǤ���

   summary: int32:checksum count-summary
   count-summary: int32:num int32:runs int64:sum int64:max int64:sum_max
*/
public final class SummaryRecord {

    /** �����å�����Ǥ��� */
    private int checksum;

    /** �����󥿿��Ǥ��� */
    private int num;

    /** �¹Բ���Ǥ��� */
    private int runs;

    /** ���٤ƤΥ����󥿤ι�פǤ��� */
    private long sumAll;

    /** maximum value on a single run. */
    private long runMax;

    /** sum of individual run max values. */
    private long sumMax;

    /**
       �Х��ȥХåե����饵�ޥ�쥳���ɤ����Ϥ��ơ����󥹥��󥹤�����
       ���ޤ����Х��ȥХåե��ΰ��֤ϥ��ޥ�쥳���ɤΥ��������Ϥ���ľ
       �ܤǤʤ���Фʤ�ޤ��������������ϡ��Х��ȥХåե��ΰ��֤�
       ���ޥ�쥳���ɤμ��ΰ��֤˿ʤߤޤ���

       @param bb �Х��ȥХåե�
       @throws IOException �����ϥ��顼
    */
    public SummaryRecord(final ByteBuffer bb) throws IOException {
	int length = bb.getInt();
	int next = bb.position() + 4 * length;

	checksum = bb.getInt();
	num = bb.getInt();
	runs = bb.getInt();
	sumAll = bb.getLong();
	runMax = bb.getLong();
	sumMax = bb.getLong();

	bb.position(next);
    }

    /**
       �¹Բ����������ޤ���

       @return �¹Բ��
    */
    public int getRuns() {
	return runs;
    }
}