#include<stdio.h>
#include<gmp.h>
void main(){
	mpf_set_default_prec(256);
	mpq_t a1;
	mpq_t a2;
	mpq_t a3;
	mpq_t b1;
	mpq_t b2;
	mpq_t b3;
	mpq_inits(a1,a2,a3,b1,b2,b3,0);
	//Reading values
	gmp_printf("Enter Value of a1: ");
	gmp_scanf("%Qi",a1);
	gmp_printf("Enter Value of a2: ");
	gmp_scanf("%Qi",a2);
	gmp_printf("Enter Value of a3: ");
	gmp_scanf("%Qi",a3);
	gmp_printf("Enter Value of b1: ");
	gmp_scanf("%Qi",b1);
	gmp_printf("Enter Value of b2: ");
	gmp_scanf("%Qi",b2);
	gmp_printf("Enter Value of b3: ");
	gmp_scanf("%Qi",b3);
	mpq_t q1;
	mpq_t q2;
	mpq_t q3;
	mpq_inits(q1,q2,q3,0);
	//Division
	mpq_div(q1,a1,b1);
	mpq_div(q2,a2,b2);
	mpq_div(q3,a3,b3);
	gmp_printf("q1=%Qi q2=%Qi q3=%Qi\n",q1,q2,q3);
	//Addtion,Substraction,Multiplication
	mpq_t sum;
	mpq_t product;
	mpq_t difference;
	mpq_inits(sum,product,difference,0);
	mpq_add(sum,q1,q2);
	mpq_add(sum,sum,q3);
	mpq_sub(difference,q1,q2);
	mpq_sub(difference,difference,q3);
	mpq_mul(product,q1,q2);
	mpq_mul(product,product,q3);
	//Converting it into floating point
	mpf_t sumf;
	mpf_t differencef;
	mpf_t productf;
	mpf_inits(sumf,differencef,productf,NULL);
	mpf_set_q(sumf,sum);
	mpf_set_q(differencef,difference);
	mpf_set_q(productf,product);
	gmp_printf("sum=%0.50Ff\ndifference=%0.50Ff\nproduct=%0.50Ff\n",sumf,differencef,productf);
	//Largest,Smallest
	mpf_t largest;
	mpf_t smallest;
	mpf_inits(largest,smallest,NULL);
	mpf_set(largest,sumf);
	mpf_set(smallest,differencef);
	if(mpf_cmp(differencef,largest)>0) mpf_set(largest,differencef);
	if(mpf_cmp(productf,largest)>0) mpf_set(largest,productf);
	if(mpf_cmp(smallest,sumf)>0) mpf_set(smallest,sumf);
	if(mpf_cmp(smallest,productf)>0) mpf_set(smallest,productf);
	gmp_printf("Smallest=%0.50Ff\nLargest=%0.50Ff\n",smallest,largest);
}
