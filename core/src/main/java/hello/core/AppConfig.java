package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
 * AppConfig는 애플리케이션의 실제 동작에 필요한 "구현 객체를 생성"한다
 */
//public class AppConfig {
//	
//	public MemberService memberService() {
//		return new MemberServiceImpl(new MemoryMemberRepository());
//	}
//	
//	public OrderService orderService( ) {
//		return new OrderServiceImpl(
//				new MemoryMemberRepository(),
//				new FixDiscountPolicy());
//	}
//}

// refactoring
public class AppConfig {
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(
				memberRepository(),
				discountPolicy());
	}
	
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}

